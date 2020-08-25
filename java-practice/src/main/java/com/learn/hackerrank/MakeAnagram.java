package com.learn.hackerrank;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MakeAnagram {
    public static void main(String[] args) {
        String a = "abcc";
        String b = "cdde";
        System.out.println(makeAnagram(a,b));
//        System.out.println(remAnagram(a,b));
    }

    /*static int remAnagram(String str1, String str2){
        int count1[] = new int[26];
        int count2[] = new int[26];

        // count frequency of each character
        // in first string
        for (int i = 0; i < str1.length() ; i++)
            count1[str1.charAt(i) -'a']++;

        System.out.println(Arrays.toString(count1));

        // count frequency of each character
        // in second string
        for (int i = 0; i < str2.length() ; i++)
            count2[str2.charAt(i) -'a']++;

        System.out.println(Arrays.toString(count2));
        // traverse count arrays to find
        // number of characters to be removed
        int result = 0;
        for (int i = 0; i < 26; i++)
            result += Math.abs(count1[i] -
                    count2[i]);
        return result;
    }*/

    static int makeAnagram(String a, String b){
        char[] charArrA = a.toCharArray();
        char[] charArrB = b.toCharArray();

        Map<Character, Long> mapA = IntStream.range(0, charArrA.length)
                .mapToObj(i -> charArrA[i])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> mapB = IntStream.range(0, charArrB.length)
                .mapToObj(i -> charArrB[i])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        mapA.forEach((key,value) -> mapB.merge(key,value, (val1,val2)-> Math.abs(val1-val2)));
        return mapB.values().stream().mapToInt(Math::toIntExact).sum();

    }
}
