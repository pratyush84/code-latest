package com.learn;

import java.util.Arrays;

public class ReverseCharArr {
    public static void main(String[] args) {
        reverseString(new char[]{'h','e','l','l','o'});
//        reverseString(new char[]{'H','a','n','n','a','h'});
    }

    public static void reverseString(char[] s) {
        int len = s.length;


        int start = 0;
        int end = len-1;

        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }



        System.out.println(Arrays.toString(s));
    }
}
