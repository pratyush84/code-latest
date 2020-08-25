package com.learn.ardentDertat;

import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverseArray(new int[]{1,2,3,4})));
    }

    static int[] reverseArray(int[] a) {
        int len = a.length;
        int start = 0;
        int end = len-1;

        while(start < len){
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }

        return a;
    }
}
