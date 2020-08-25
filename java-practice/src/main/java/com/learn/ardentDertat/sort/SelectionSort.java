package com.learn.ardentDertat.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(Arrays.toString(selectionSort(new int[]{5,3,7,2})));
        long endTime = System.nanoTime();
        System.out.println("Time Taken - " + (endTime-startTime));
    }

    static int[] selectionSort(int[] a){
        int min = a[0];
        int len = a.length;

        for (int i = 0; i < len; i++) {
            min = i;
            for (int j = i+1; j < len; j++) {
                if(a[j] < a[min]){
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        return a;
    }
}
