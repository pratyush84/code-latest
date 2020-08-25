package com.learn.hackerrank.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.OptionalInt;

public class CountingSort {
    public static int[] sort(int[] arr){
        int arrSize = arr.length;

        int max = Arrays.stream(arr).max().orElse(0);
        int[] countArr = new int[max + 1];

        for (int i = 0; i < arrSize ; i++) {
            int ind = arr[i];
            countArr[ind] += 1;
        }

        System.out.println(Arrays.toString(countArr));

        int[] sortedArr = new int[arrSize];

        int k = 0;
        for (int i = 0; i < countArr.length; i++) {
            if(countArr[i] != 0){
                int limit = countArr[i] + k;
                int j = 0;
                for ( j = k; j < limit; j++) {
                    sortedArr[j] = i;
                }
                k = j;
            }
        }

        return sortedArr;
    }
}
