package com.learn.hackerrank;

import java.util.Arrays;
import java.util.OptionalInt;

public class ArrayManipulation {
    public static void main(String[] args) {
        int[][] arr = {{1,2,100},{2,5,100},{3,4,100}};
        System.out.println(arrayManipulation(5,arr));
    }

    public static int arrayManipulation(int n, int[][] queries){
        int len = queries.length;

        int[] zeroArr = new int[n + 2];

        for (int i = 0; i < len; i++) {
            int minIndex = queries[i][0];
            int maxIndex = queries[i][1];
            int summand = queries[i][2];
            zeroArr[minIndex] += summand;
            zeroArr[maxIndex + 1] -=summand;

        }


        return findMax(zeroArr);
    }

    private static int findMax(int[] arr){
      int max = Integer.MIN_VALUE;
      int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max,sum);
        }
        return max;
    }

    }

