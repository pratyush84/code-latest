package com.learn.hackerrank;

import java.util.Arrays;

public class MarksAndToys {

    public static void main(String[] args) {
        System.out.println(maximumToys(new int[]{1,12,5,111,200,1000,10},50));
    }
    static int maximumToys(int[] prices, int k){
        int[] sortedArr = Arrays.stream(prices)
                .sorted()
                .toArray();

        int sum = 0;
        int i = 0;
        for ( i=0; i < sortedArr.length; i++) {
            sum += sortedArr[i];
            if(sum > k)
                break;
        }

        return i;

    }
}
