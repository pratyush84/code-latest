package com.learn;

import java.lang.reflect.Array;
import java.util.Arrays;

public class practiceClass {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,4,3,5,6,6,6,7};
        System.out.println(Arrays.toString(removeDupInt(arr)));

        String[] strArr = new String[]{"pratyush","PratYUsh","sharma","Sharma","sharma"};
        String[] strArr1 = new String[]{"sharma","sharma"};
        System.out.println(Arrays.toString(removeDupStr(strArr)));
    }
    private static int[] removeDupInt(int[] input){
        return Arrays.stream(input)
                .distinct()
                .toArray();
    }

    private static Object[] removeDupStr(String[] input){
        return Arrays.stream(input)
                .map(String::toLowerCase)
                .distinct()
                .toArray();
    }
}
