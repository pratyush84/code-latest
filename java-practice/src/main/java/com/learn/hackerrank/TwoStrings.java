package com.learn.hackerrank;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TwoStrings {

    public static void main(String[] args) {
        System.out.println(twoStrings("hi","world"));
    }
    private static String twoStrings(String s1, String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Stream<Character> cStream1 = IntStream.range(0, chars1.length).mapToObj(i -> chars1[i]);
        Stream<Character> cStream2 = IntStream.range(0, chars2.length).mapToObj(i -> chars2[i]);

        Map<Character, Long> collect1 = cStream1.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character, Long> collect2 = cStream2.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect1.toString());
        System.out.println(collect2.toString());

        boolean match = collect1.entrySet()
                .stream()
                .anyMatch(entry -> collect2.containsKey(entry.getKey()));

        if(match) {
            return "YES";
        }else
            return "NO";

    }
}
