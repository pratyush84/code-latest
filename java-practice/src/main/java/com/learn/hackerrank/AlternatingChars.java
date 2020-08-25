package com.learn.hackerrank;

public class AlternatingChars {

    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AAABBB"));
    }
    static int alternatingCharacters(String s){
        char[] chars = s.toCharArray();

        int len = chars.length;

        int delCount = 0;

        for (int i = 0; i < len-1; i++) {
          if(chars[i] == chars[i+1]){
              delCount++;
          }
        }
        return delCount;
    }
}
