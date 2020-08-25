package com.learn.hackerrank.search;


import com.sun.deploy.ui.DialogTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
//        int[] input = new int[]{1,2,3,4,99,102,167};
        int[] input = {1,8,999,10000,12000};
        int search = 899;
        int low = 0;
        int high = input.length-1;

        Integer[] input1 = {1,2,3,4};
        List<Integer> list = Arrays.asList(input1);
        list.sort(Comparator.naturalOrder());

        System.out.println(binarySearch(input,low,high,search));

    }

    public static int binarySearch(int[] input, int low, int high,int search){
        int len = input.length;
        int num = 12;

        while(low <= high){
            System.out.println("High="+high+" Low"+low);
            int mid = (low + high)/2;
            if(input[mid] == search){
                return mid;
            }else if(search > input[mid]){
                return binarySearch(input,mid+1, high,search);
            } else {
                return binarySearch(input, low,mid-1, search);
            }
        }
        System.out.println("Start = " + low + " End=" + high);
        return -1;
    }
}
