package com.learn.hackerrank.sort;

public class BubbleSort {
    public static int[] sort(int[] arr){
        int swapCount = 1;

        int len = arr.length;

        while(swapCount > 0) {
            swapCount = 0;
            for (int i = 1; i < len; i++) {
                if (arr[i-1] > arr[i]) {
                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                    swapCount++;
                }
            }
        }

        return arr;
    }


}
