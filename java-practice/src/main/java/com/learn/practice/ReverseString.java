package com.learn.practice;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReverseString {

    public static void main(String[] args) {
        String s = "pratyush";
//        System.out.println(reverse(s));
        System.out.println(Stream.of(s)
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" ")));
    }

    public static String reverse(String str){
        char[] charArr = str.toCharArray();
        int len = charArr.length;
        char[] reversed = new char[len];



        int j = 0;
        for (int i = len - 1; i >= 0; i--) {
            reversed[j] = charArr[i];
            j++;
        }
        return String.valueOf(reversed);
    }

}
