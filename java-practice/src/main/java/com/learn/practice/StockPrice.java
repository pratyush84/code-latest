package com.learn.practice;

import java.util.Arrays;

public class StockPrice {
    public static void main(String[] args) {
        int[] stockPrices = new int[] {5};
        System.out.println(getMaxProfit(stockPrices));
    }

    public static int getMaxProfit(int[] arr) {


        int arrLen = arr.length;
        if(arrLen < 2){
            throw new IllegalArgumentException("Exception");
        }
        int[] diffArr = new int[arrLen - 1];

        for (int i = 0; i < arrLen - 1; i++) {
            int max = findMax(Arrays.copyOfRange(arr, i+1,arrLen));
            diffArr[i] = max - arr[i];
        }

        return findMax(diffArr);
    }

    private static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
