package com.spark.accumulator.core.impl;

import com.spark.accumulator.core.BatchSources;

public enum Batch implements BatchSources {
    SOURCE1{
        @Override
        public String getSourceName() {
            return null;
        }

        @Override
        public String getCustomerID() {
            return null;
        }

        @Override
        public double getBatchSize() {
            return 0;
        }
    },
    SOURCE2{
        @Override
        public String getSourceName() {
            return null;
        }

        @Override
        public String getCustomerID() {
            return null;
        }

        @Override
        public double getBatchSize() {
            return 0;
        }
    }
}
