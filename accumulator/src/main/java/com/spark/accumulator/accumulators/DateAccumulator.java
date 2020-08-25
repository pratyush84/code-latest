package com.spark.accumulator.accumulators;


import org.apache.spark.util.AccumulatorV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class DateAccumulator extends AccumulatorV2<Integer, Map<ZonedDateTime,Integer>> implements Serializable {
    private static Logger LOGGER = LoggerFactory.getLogger(DateAccumulator.class);
    private static final long serialVersionUID = 1L;
    private Map<ZonedDateTime,Integer> map = new HashMap<>();

    public void mapCleanUp(){
        LOGGER.info("Cleaning map");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss");
        ZonedDateTime currTS = getCurrentTimestamp();
        LOGGER.info("Current Time: {}", currTS.toString());
        map.entrySet().removeIf(entry -> entry.getKey().isBefore(currTS));
    }

    @Override
    public boolean isZero() {
        return map.isEmpty();
    }

    @Override
    public AccumulatorV2<Integer, Map<ZonedDateTime, Integer>> copy() {
        DateAccumulator newAcc = new DateAccumulator();
        newAcc.map = map;
        return newAcc;
    }

    @Override
    public void reset() {
        map = new HashMap<>();
    }

    @Override
    public void add(Integer v) {
//        String currentDate = getCurrentDate();
//        String currentTimestamp = getCurrentTimestampString();
        ZonedDateTime currentTimestamp = getCurrentTimestamp();
        map.put(currentTimestamp, map.getOrDefault(currentTimestamp, 0) + v);
    }

    @Override
    public void merge(AccumulatorV2<Integer, Map<ZonedDateTime, Integer>> other) {

    }

    @Override
    public Map<ZonedDateTime, Integer> value() {
        return map;
    }

    private String getCurrentDateString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        return now.format(formatter);
    }

    private String getCurrentTimestampString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss");
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));

        return now.format(formatter);
    }

    private ZonedDateTime getCurrentTimestamp(){
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        return now.minusSeconds(1);
    }
}
