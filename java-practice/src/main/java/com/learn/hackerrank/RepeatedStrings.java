package com.learn.hackerrank;

import java.util.Arrays;

public class RepeatedStrings {
    public static void main(String[] args) {
        String input = "a";
        long repeat = 1000000000000l;
        int strLength = input.length();
        System.out.println("String length " + strLength);

        int countOfA = getCountOfA(input);
        System.out.println("Count of a " + countOfA );

        long factor = repeat/strLength;
        long remaining = repeat % strLength;

        long aCount = (countOfA  * factor) + getCountOfA(input.substring(0,(int)remaining));

        System.out.println(aCount);
    }

    private static int getCountOfA(String input) {
        int countOfA = 0;
        for(char ch : input.toCharArray()){
            if(ch == 'a'){
                countOfA++;
            }
        }
        return countOfA;
    }
}
