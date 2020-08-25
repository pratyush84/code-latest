package com.learn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        whatFlavors(new int[]{1,4,5,3,2},4);
    }
    static void whatFlavors(int[] cost, int money){
        Map<Integer,Integer> map = new HashMap<>();
        int len = cost.length;
        int first = 0;
        int second = 0;


        for (int i = 0; i < len; i++) {
            if (cost[i] < money) {
                if (!map.getOrDefault(money - cost[i], -1).equals(-1)) {
                    first = map.get(money - cost[i]) + 1;
                    second = i + 1;
                } else
                    map.put(cost[i], i);
            }
        }

        System.out.println(first + " " + second);
    }
}
