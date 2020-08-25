package com.learn.hackerrank.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        int[] arr = {4,2,1,3,9,10,0};
        int[] arr1 = {1,12,5,111,200,1000,10};
//        System.out.println(Arrays.toString(SelectionSort.sort(arr)));
//        System.out.println(Arrays.toString(BubbleSort.sort(arr)));
        System.out.println(Arrays.toString(CountingSort.sort(arr1)));
    }
}
