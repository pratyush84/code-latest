package com.learn.hackerrank.sort;

public class SelectionSort {
    public static int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min_index = i;
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index]= temp;
        }
        return arr;
    }



    public static int findIndex(int[] arr, int key){
        int index = 0;
        for (int i = 0; i <  arr.length; i++) {
            if(arr[i] ==  key){
                index = i;
            }
        }
        return index;
    }
    public static int findMin(int[] arr){
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > arr[i+1]){
                min = arr[i+1];
            }
        }
        return min;
    }
}
