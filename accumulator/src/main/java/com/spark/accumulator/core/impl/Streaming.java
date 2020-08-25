package com.spark.accumulator.core.impl;

import com.spark.accumulator.core.StreamingSources;

public enum Streaming implements StreamingSources {
    STR_SOURCE1{
        @Override
        public String getSourceName() {
            return null;
        }

        @Override
        public String getCustomerID() {
            return null;
        }

        @Override
        public String encryptData() {
            return null;
        }

        @Override
        public String decryptData() {
            return null;
        }
    },

    STR_SOURCE2 {
        @Override
        public String getSourceName() {
            return null;
        }

        @Override
        public String getCustomerID() {
            return null;
        }

        @Override
        public String encryptData() {
            return null;
        }

        @Override
        public String decryptData() {
            return null;
        }
    }
}
