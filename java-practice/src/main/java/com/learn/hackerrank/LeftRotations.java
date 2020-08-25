package com.learn.hackerrank;

import java.util.Arrays;

public class LeftRotations {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int numRotations = 19;

        int arrLength = arr.length;

        int[] rotatedArr = new int[arrLength];

        for (int i = 0; i < arrLength ; i++) {
            int newIndex = i - numRotations;
            while (newIndex < 0){
                newIndex = arrLength + newIndex;
            }
            rotatedArr[newIndex] = arr[i];
        }

        System.out.println(Arrays.toString(rotatedArr));
    }
}
