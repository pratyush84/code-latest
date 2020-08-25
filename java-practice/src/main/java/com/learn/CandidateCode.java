package com.learn;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CandidateCode {
    public static void main(String args[] ) throws Exception {

        //Write code here
        Scanner input = new Scanner(System.in);
        String ingStr = input.nextLine();

        String reqQuan = input.nextLine();
        String availQuan = input.nextLine();

        Long ingQuan;
        try {
            ingQuan = Long.parseLong(ingStr);
        } catch (NumberFormatException ex){
            ingQuan = 0L;
        }

        List<Long> requiredQuantity = Arrays.stream(reqQuan.split(" ")).filter(item -> !item.isEmpty()).
                map(Long::parseLong).filter(item -> item >= 0).collect(Collectors.toList());
        List<Long> availableQuantity = Arrays.stream(availQuan.split(" ")).filter(item -> !item.isEmpty()).
                map(Long::parseLong).filter(item -> item > 0).collect(Collectors.toList());



        List<Long> divisionList = new ArrayList<>();
        if((ingQuan == requiredQuantity.size()) && (ingQuan == availableQuantity.size()) ) {
            divisionList = availableQuantity.stream().map(item -> item / requiredQuantity.get(availableQuantity.indexOf(item))).collect(Collectors.toList());
        }

        Optional<Long> min = divisionList.stream().min(Comparator.comparing(Long::valueOf));

        System.out.println(min.orElse(0L));

    }
}

