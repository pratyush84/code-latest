package com.learn.hackerrank;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NewYearChaos {
    public static void main(String[] args) {

        int[] bribedArr = {1,2,5,3,7,8,6,4};
//        minimumBribes(bribedArr);
        minimumBribes1(bribedArr);

    }

    public static void minimumBribes1(int[] bribedArr){
        System.out.println(Arrays.toString(bribedArr));
        int[] origArr = IntStream.range(1,bribedArr.length).toArray();
        System.out.println(Arrays.toString(origArr));

        boolean chaotic = false;
        int bribes = 0;

        for (int i = 0; i < bribedArr.length; i++) {
            if(bribedArr[i] - (i+1) > 2){
                chaotic = true;
                break;
            }

            int max = Math.max(0,bribedArr[i]-2);
            for (int j = max; j < i; j++) {
                if(bribedArr[j] > bribedArr[i]){
                    bribes++;
                }
            }
        }
        if(chaotic){
            System.out.println("Too chaotic");
        } else{
            System.out.println(bribes);
        }
    }

    public static void minimumBribes(int[] bribedArr){
        System.out.println(Arrays.toString(bribedArr));
        int[] origArr = IntStream.range(1,bribedArr.length).toArray();
        System.out.println(Arrays.toString(origArr));

        int[] origIndex = IntStream.range(0,origArr.length).toArray();
        int[] bribedIndex = Arrays.stream(origArr).map(elem -> ArrayUtils.indexOf(bribedArr, elem)).toArray();


        System.out.println(Arrays.toString(origIndex));
        System.out.println(Arrays.toString(bribedIndex));


        int[] diffIndex = Arrays.stream(origIndex).map(elem -> elem - bribedIndex[elem]).toArray();
        System.out.println(Arrays.toString(diffIndex));

        int posSum = Arrays.stream(diffIndex).filter(elem -> elem > 0).sum();

        final String[] returnValue = {String.valueOf(posSum)};

        Arrays.stream(diffIndex).forEach(elem -> {
            if(elem >=3){
                returnValue[0] = "Too chaotic";

            }
        });

        System.out.println(returnValue[0]);
    }
}
