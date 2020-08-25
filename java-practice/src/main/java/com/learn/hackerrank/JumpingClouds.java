package com.learn.hackerrank;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class JumpingClouds {
    public static void main(String[] args) {
        int[] input = new int[]{0,0,1,0,0,0,0,1,0,0};
        int[] filteredArray = Arrays.stream(input).filter(num -> num != 1).toArray();
        int[] indexArr = new int[filteredArray.length];

        int i = 0;
        int j = 0;

        for (int num : input){
            if(num == 0){
                indexArr[i] = j;
                i++;
            }
            j++;
        }

        System.out.println(ArrayUtils.toString(indexArr));

        int k = 0;
        int count  = 0;


        for(int num : indexArr){

            if(ArrayUtils.contains(indexArr,k + 2)){
                k += 2;
                count++;
            } else if(ArrayUtils.contains(indexArr, k + 1)){
                k++;
                count++;
            }

        }
        System.out.println("Number of Jumps - " +  count);
    }
}
