package com.learn.ardentDertat.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(Arrays.toString(bubbleSort(new int[]{5,3,7,2})));
        long endTime = System.nanoTime();
        System.out.println("Time Taken - " + (endTime-startTime));
    }

    static int[] bubbleSort(int[] arr){
        int len = arr.length;
        boolean isSwapped = true;

        while(isSwapped){
            for (int i = 1; i < len; i++) {
                isSwapped = false;
                if(arr[i-1] > arr[i]){
                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                    isSwapped = true;
                }

            }

        }
        return arr;
    }
}
