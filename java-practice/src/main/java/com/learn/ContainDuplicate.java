package com.learn;

import java.util.HashSet;
import java.util.Set;

public class ContainDuplicate {

    public static void main(String[] args) {
//        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsDuplicateUnsorted(new int[]{1,2,3,4}));
    }

    public static boolean containsDuplicateUnsorted(int[] nums){
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
    public static boolean containsDuplicate(int[] nums){
        int[] sorted = selectionSort(nums);

        int len = sorted.length;
        int i=0;
        for (int j = 1; j < len; j++) {
            if(sorted[j] == sorted[i]){
                return true;
            }
            i++;
        }
        return false;
    }

    public static int[] selectionSort(int[] nums){
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int min_index = i;

            for (int j = i+1; j < len ; j++) {
                if(nums[j] < nums[min_index] ){
                    min_index = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[min_index];
            nums[min_index] = temp;

        }

        return nums;
    }
}
