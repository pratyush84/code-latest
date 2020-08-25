package com.learn.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ReverseSentence {
    public static void main(String[] args) {
        String s = "the fox attacked the zebra";
//        System.out.println(revSimple(s));
        System.out.println(revLambda(s));
    }

    static String revLambda(String s){
        List<String> list = Arrays.asList(s.split(" "));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    static String revSimple(String s){
        String[] strArr = s.split(" ");

        int len = strArr.length;

        String[] revArr = new String[len];

        for (int i = 0; i < len ; i++) {
            revArr[i] = strArr[len-i-1];
        }
        return String.join(" ", revArr);
    }
}
