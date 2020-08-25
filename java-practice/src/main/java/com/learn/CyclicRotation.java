package com.learn;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CyclicRotation {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        System.out.println(ArrayUtils.toString(rotateArray( array, 3)));
    }

    public static int[] rotateArray(int[] array, int k){
        int arrSize = array.length;
        int[] rotatedArray = new int[arrSize + k];

        if(arrSize == k){
            return array;
        }

        for (int i = 0; i < arrSize ; i++) {
            int newPos = i+k;
            if (newPos > arrSize - 1){
                newPos = newPos - arrSize;
            }
            rotatedArray[newPos] = array[i];
        }

        return removeExtraZeroes(rotatedArray);
    }

    private static int[] removeExtraZeroes(int[] inputArray){
        return Arrays.stream(inputArray).boxed().filter(num -> num != 0).mapToInt(Integer::intValue).toArray();
    }
}
