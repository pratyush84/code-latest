package com.learn.hackerrank;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RansomNote {

    public static void main(String[] args) {
//        checkMagazine(new String[]{"two","times","three","is","four","two"},new String[]{"two","times","two","is","four"});
        checkMagazine(new String[]{"apgo","clm","w","lxkvg","mwz","elo","bg","elo","lxkvg","elo","apgo","apgo","w","elo","bg"},
                new String[]{"elo","lxkvg","bg","mwz","clm","w"});
    }
    public static void checkMagazine(String[] magazine, String[] note){
        Map<String, Long> magMap = Arrays.stream(magazine).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(magMap.toString());

        Map<String,Long> noteMap = Arrays.stream(note).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(noteMap.toString());

        boolean match = noteMap.entrySet()
                .stream()
                .allMatch(entry -> magMap.containsKey(entry.getKey()) && magMap.get(entry.getKey()) >= entry.getValue());

        System.out.println(match);

    }
}
