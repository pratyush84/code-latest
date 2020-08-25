package com.learn.ardentDertat;

import java.util.Arrays;

public class ArrayPair {
    public static void main(String[] args) {
        int[] input = new int[]{2,4,6,1,0,7,8};
        int k = 6;

        Arrays.sort(input);
        System.out.println(Arrays.toString(input));

        int left = 0;
        int right = input.length - 1;
        while (left < right){
            int currSum = input[left] + input[right];
            if(currSum == k){
                System.out.println(input[left] + ", " + input[right]);
                left++;
            } else if(currSum < k){
                left++;
            } else {
                right--;
            }
        }
    }
}
