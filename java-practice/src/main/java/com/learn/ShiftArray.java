package com.learn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShiftArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shift(new int[]{1,2,3,4,5},4)));
        Map<String,Integer> map = new HashMap<>();
    }

    static int[] shift(int[] a, int k){
        int len  =  a.length;
        int[] rev = new int[len];

        for (int i = 0; i < len; i++) {
            int newPos = len + i-k;
            if(newPos >= len){
                newPos = newPos - len;
            }
            rev[newPos] = a[i];
        }

        return rev;
    }
}
