package com.learn.ardentDertat.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(Arrays.toString(insertionSort(new int[]{5,3,7,2})));
        long endTime = System.nanoTime();
        System.out.println("Time Taken - " + (endTime-startTime));
    }

    static int[] insertionSort(int[] a){
        int len = a.length;

        for (int i = 1; i < len; i++) {
            int key = a[i];
            int j = i-1;

            while (j>=0 && a[j] > key){
                a[j+1] = a[j];
                --j;
            }
            a[j+1] = key;
        }
        return a;
    }
}
