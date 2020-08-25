package com.learn.functional.udemy;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FP03BehaviorParameterization {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12,9,13,4,2,7,90 );

//        filterAndPrint(numbers, x1 -> x1 % 2 == 0);
//
//        filterAndPrint(numbers, x -> x % 2 != 0);

//        List<Integer> doubleNumbers = mapAndPrint(numbers, x -> x * 2);
//        System.out.println(doubleNumbers);

        Supplier<Integer> randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };
//        System.out.println(randomIntegerSupplier.get());

        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
        System.out.println(unaryOperator.apply(2) );
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

    private static List<Integer> mapAndPrint(List<Integer> numbers, Function<Integer,Integer> function){
        return numbers.stream()
                .map(function)
                .collect(Collectors.toList());
    }
}
