package com.learn.ardentDertat.sort;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        int[] input = new int[]{3,2,1,6,8,5,7,4};
        QuickSort quickSort = new QuickSort(input,8);
        quickSort.quickSort(0,7);

        System.out.println(Arrays.toString(input));
    }
}
