package com.spark.accumulator.SparkCustomListener;

import org.apache.spark.streaming.scheduler.*;

public class SparkStreamingCustomListener implements StreamingListener {
    @Override
    public void onBatchCompleted(StreamingListenerBatchCompleted batchCompleted) {
        System.out.println("Batch completed, Total delay :" + batchCompleted.batchInfo().totalDelay().get().toString() +  " ms");
        System.out.println("Number of records in batch :" + batchCompleted.batchInfo().numRecords() );
   }


    @Override
    public void onReceiverStarted(StreamingListenerReceiverStarted receiverStarted) {

    }

    @Override
    public void onReceiverError(StreamingListenerReceiverError receiverError) {

    }

    @Override
    public void onReceiverStopped(StreamingListenerReceiverStopped receiverStopped) {

    }

    @Override
    public void onBatchSubmitted(StreamingListenerBatchSubmitted batchSubmitted) {

    }

    @Override
    public void onBatchStarted(StreamingListenerBatchStarted batchStarted) {

    }

    @Override
    public void onOutputOperationCompleted(StreamingListenerOutputOperationCompleted outputOperationCompleted){
    }

    @Override
    public void onOutputOperationStarted(StreamingListenerOutputOperationStarted outputOperationStarted){}

    @Override
    public void onStreamingStarted(StreamingListenerStreamingStarted streamingListenerStreamingStarted){}
}
