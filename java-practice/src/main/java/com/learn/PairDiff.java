package com.learn;

import java.util.HashSet;
import java.util.Set;

public class PairDiff {
    public static void main(String[] args) {
        System.out.println(pairs(2, new int[]{1,5,3,4,2}));
    }

    static int pairs(int k, int[] arr) {
        int len = arr.length;

        Set<Integer> compSet = new HashSet<>();

        int count = 0;

        for (int i = 0; i < len; i++) {
            int sum = arr[i] + k;
            int diff = Math.abs(arr[i] - k);
            if(compSet.contains(sum) ){
                count++;
            }
            if( compSet.contains(diff)){
                count++;
            }
            compSet.add(arr[i]);
        }

        return count;
    }

   /* static int twoPointerApp(int k, int[] arr){

    }*/



    static int partition(int[] arr, int left, int right, int pivot){
        int leftPtr = left - 1;
        int rightPtr = right;

        while(true){
            while (arr[++leftPtr] < pivot);

            while (rightPtr > 0 && arr[--rightPtr] > pivot);

            if(leftPtr > rightPtr)
                break;
            else
                swap(arr,leftPtr,rightPtr);
        }

        swap(arr,leftPtr,right);
        return 0;
    }

    static int[] swap(int[] a, int left, int right){
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
        return a;
    }
}
