package com.spark.accumulator.SparkCustomListener;

import org.apache.spark.scheduler.AccumulableInfo;
import org.apache.spark.scheduler.SparkListener;
import org.apache.spark.scheduler.SparkListenerStageCompleted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;
import scala.collection.JavaConversions;

import java.util.Collection;

public class SparkStageListener extends SparkListener {

    private static Logger LOGGER = LoggerFactory.getLogger(SparkStageListener.class);
    @Override
    public void onStageCompleted(SparkListenerStageCompleted event){
        scala.collection.mutable.HashMap<Object, AccumulableInfo> map = event.stageInfo().accumulables();
        Collection<Tuple2<Object, AccumulableInfo>> newMap = JavaConversions.asJavaCollection(map);
        LOGGER.info("onStageCompleted " +  newMap.toString());
        for (Tuple2<Object, AccumulableInfo> t : newMap) {
            LOGGER.info("Inside loop");
            if (t._2.name().get().equalsIgnoreCase("counter-accumulator")) {
                LOGGER.info("It is here" + t._1 + "    " + t._2.name().get() + "   " + t._2.value().get().toString());
            }
        }
    }
}
