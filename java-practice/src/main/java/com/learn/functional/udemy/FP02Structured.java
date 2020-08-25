package com.learn.functional.udemy;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class FP02Structured {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12,9,13,4,2,7,90 );
        int sum = addListFunctional(numbers);
//        int sum = sumOfOdd(numbers);
//        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
//        courses.stream().sorted(new LengthDecComparator()).forEach(System.out::println);
        System.out.println(sum);
    }


    private static int addListFunctional(List<Integer> numbers){
        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer +  integer2;
            }
        };
        return numbers.stream()
                .reduce(0, binaryOperator);
    }

    private static int sumOfSquares(List<Integer> numbers){
      return numbers.stream().map(num -> num * num * num).reduce(0, Integer::sum);
    }

    private static int sumOfOdd(List<Integer> numbers){
        return numbers.stream().filter(num -> num % 2 == 1).reduce(0, Integer::sum);
    }
}
