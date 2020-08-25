package com.learn.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraySum {
    public static void main(String[] args) {
        int[] arr = {2,4,6,10};
        int target = 16;
        System.out.println(Arrays.toString(arrSumLin(arr, target)));
    }

    static int[] arrSumAll(int[] arr, int target){
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int sum = 0;

            }
        }
        return new int[2];
    }

    static int[] arrSum(int[] arr, int target){
        int len = arr.length;

        int[] targetArr = new int[2];

        int low = 0;
        int high = len - 1;

        while (low < high){
            int currSum = arr[low] + arr[high];

            if(currSum == target){
                targetArr[0] = arr[low];
                targetArr[1] = arr[high];
                return targetArr;
            } else if(currSum < target){
                low++;
            } else
                high--;
        }

        return targetArr;
    }

    static int[] arrSumLin(int[] arr, int target){
        if(arr.length < 2){
            return new int[]{0, 0};
        }
        Set<Integer> seen = new HashSet<>();
        int[] output = new int[2];

        for(int num: arr){
            int tgt = target - num;
            if(!seen.contains(tgt)){
                seen.add(num);
            } else {
                output[0] = (Math.min(tgt,num));
                output[1] = (Math.max(tgt,num));
            }
        }


        return output;
    }
}
