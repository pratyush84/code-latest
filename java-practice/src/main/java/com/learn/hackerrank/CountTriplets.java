package com.learn.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CountTriplets {
    public static void main(String[] args) {
        List<Long> list = Arrays.asList(1L,5L,5L,25L,125L);
        System.out.println(countTriplets(list,5));
    }
    private static long countTriplets(List<Long> arr, long r){
        int count=0;
        for (int i = 0; i < arr.size() - 2; i++) {
            for (int k = i+1; k < arr.size() - 1; k++) {
                for (int l = k+1; l < arr.size() ; l++) {
                    List<Long> list = new ArrayList<>();
                    list.add(arr.get(i));
                    list.add(arr.get(k));
                    list.add(arr.get(l));

                    if(isGeoProgression(list, r)) {
                        count++;
                    }

                }
                
            }
        }
        return count;
    }

    private static boolean isGeoProgression(List<Long> list, long r){
        list.sort(Comparator.naturalOrder());
        if(list.contains(0)){
            return false;
        }

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) / list.get(i - 1) != r )
                return false;
        }

        return true;
    }
}
