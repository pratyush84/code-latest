package com.learn.hackerrank;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SherlockAnagrams {

    public static void main(String[] args) {
//        System.out.println("if".equals("fi"));
        System.out.println(sherlockAndAnagrams("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
    private static int sherlockAndAnagrams(String s){
        int count = 0;
        for (int i = 1; i < s.length()  ; i++) {
            int j = 0;

            List<String> strList = new ArrayList<>();

            while (j+i <= s.length()) {
                strList.add(s.substring(j, j+i));
                j++;
            }
            count +=anagramCount(strList);
        }
        return count;
    }

    private static Double anagramCount(List<String> list){
        Map<String, Long> map = list.stream().map(item -> {
            char[] charArr = item.toCharArray();
            Arrays.sort(charArr);
            return String.valueOf(charArr);
        }).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map.toString());
        Optional<Double> comb = map.values()
                .stream()
                .filter(aLong -> aLong > 1)
                .map(aLong -> calcComb(aLong, 2))
                .reduce(Double::sum);
        return comb.orElse(0.);
    }

    private static double calcComb(double set, double subSet){
        return factorial(set) / (factorial(subSet) * factorial(set - subSet));
    }

    private static double factorial(double num){
         if(num == 0){
             return 1;
         } else
             return num * factorial(num - 1);
    }

    private static boolean isAnagram(String s1, String s2){
        if(s1.length() == s2.length()){
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();

            Stream<Character> stream1 = IntStream.range(0, chars1.length).mapToObj(i -> chars1[i]);
            Stream<Character> stream2 = IntStream.range(0, chars2.length).mapToObj(i -> chars2[i]);

            List<Character> list1 = stream1.collect(Collectors.toList());
            List<Character> list2 = stream2.collect(Collectors.toList());

            return list2.containsAll(list1);
        }

        return false;
    }
}
