package com.learn.functional.udemy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
//        printAllNumbersInListStructured(Arrays.asList(12,9,13,4,2,7,90));
//        printAllNumbersInListFunctional(Arrays.asList(12,9,13,4,2,7,90));
//        printOddNumbersFunctional(Arrays.asList(12,9,13,4,2,7,90));
//        printallCourses(Arrays.asList("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes"));
//        printAtleast4Letters(Arrays.asList("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes"));
//        funcEx06(Arrays.asList(12,9,13,4,2,7,90));
        funxEx07(Arrays.asList("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes"));
    }

    private static void funxEx07(List<String> inputList) {
        inputList.stream().map(String::length).forEach(System.out::println);
    }

    private static void funcEx06(List<Integer> numbers) {
        numbers.stream().map(x -> Math.pow(x, 3)).forEach(System.out::println);
    }

    private static void printAtleast4Letters(List<String> inputList) {
        inputList.stream().filter(item -> item.length() >= 4).forEach(System.out::println);
    }

    private static void printallCourses(List<String> inputList) {
        inputList.stream().filter(item -> item.contains("Spring")).forEach(System.out::println);
    }

    private static void printOddNumbersFunctional(List<Integer> numbers) {
        numbers.stream().filter(number -> number % 2 != 0).forEach(System.out::println);
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().filter(num -> num % 2 == 0).map(num -> num * num).forEach(System.out::println);
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        for(int num: numbers){
            System.out.println(num);
        }

    }
}
