package com.spark.accumulator;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.kinesis.AmazonKinesisClient;
import com.amazonaws.services.kinesis.clientlibrary.lib.worker.InitialPositionInStream;
import com.spark.accumulator.accumulators.DateAccumulator;
import com.spark.accumulator.util.DBUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kinesis.KinesisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SparkListener {

    private static Logger LOGGER = LoggerFactory.getLogger(SparkListener.class);
    private static DateAccumulator dateAccumulator = new DateAccumulator();
    private static DateAccumulator successAcc = new DateAccumulator();
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                LOGGER.info("Shutdown Called, Inserting to DB.");
                insertToDb(dateAccumulator.value());
            }
        });
        SparkConf sconf = new SparkConf();
        sconf.setAppName("RT-AUDIT");
        sconf.setMaster("local[4]");

        JavaStreamingContext jssc = new JavaStreamingContext(sconf, Durations.milliseconds(1000));

        jssc.sparkContext().sc().register(dateAccumulator,"counter-accumulator");



        AWSCredentials credentials = new DefaultAWSCredentialsProviderChain().getCredentials();
        AmazonKinesisClient kinesisClient = new AmazonKinesisClient(credentials);
        kinesisClient.setEndpoint("https://kinesis.us-east-1.amazonaws.com");

        JavaReceiverInputDStream<byte[]> inputStream = KinesisUtils.createStream(jssc, "checkpoint1", "stream-name", "https://kinesis.us-east-1.amazonaws.com",
                "us-east-1", InitialPositionInStream.TRIM_HORIZON, new Duration(10000), StorageLevel.MEMORY_ONLY());

        getAccumulatorValue();
        inputStream.foreachRDD((JavaRDD<byte[]> rdd) -> {

            rdd.foreachPartition((VoidFunction<Iterator<byte[]>>) record -> {
                record.forEachRemaining(item -> {
                    String strItem = new String(item);
                    LOGGER.info("Output is ---");
                    LOGGER.info(strItem.split(",")[0]);
//                    acc.add(1.0);
                    dateAccumulator.add(1);
                });
//                getAccumulatorValue(dateAccumulator);
//                persistAccumulatorValue(dateAccumulator);
            });

        });

        jssc.start();

        try {
            jssc.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void persistAccumulatorValue(){
        if(!dateAccumulator.isZero()){
            System.out.println("Accumulator-Value: " + dateAccumulator.value().toString());
        }
    }

    private static void getAccumulatorValue() {
        ScheduledExecutorService scheduled =
                Executors.newScheduledThreadPool(1);
        LOGGER.info("Instantiate for first time.");
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                LOGGER.info("Scheduled runs.");
                if(!dateAccumulator.isZero()) {

                    LOGGER.info("Accumulator-Value: {}" , dateAccumulator.value().toString());
                    insertToDb(dateAccumulator.value());
                }
                LOGGER.info("Cleaning maps. Calling from main.");
                dateAccumulator.mapCleanUp();
                LOGGER.info("Accumulator-Value post clean-up: {}", dateAccumulator.value().toString());
            }
        },5,5, TimeUnit.SECONDS);
    }


    private static void insertToDb(Map<ZonedDateTime, Integer> accMap){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
        LOGGER.info("Inserting Accumulator Values to DB.");
        accMap.forEach((key, count) -> {
            String ingestionId = "rt".concat(key.format(formatter));
            DBUtils.insertTable(ingestionId, count);
        });
    }

}
