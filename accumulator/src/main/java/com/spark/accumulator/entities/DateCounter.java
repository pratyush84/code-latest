package com.spark.accumulator.entities;

import java.util.Date;
import java.util.Map;

public class DateCounter {
   private Map<Date, Double> map;

    public DateCounter(Map<Date, Double> map) {
        this.map = map;
    }
}
