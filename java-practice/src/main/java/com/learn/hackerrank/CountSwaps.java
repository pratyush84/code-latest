package com.learn.hackerrank;

public class CountSwaps {

    public static void main(String[] args) {
        countSwaps(new int[]{3,2,1});
    }
    public static void countSwaps(int[] a){
        int n = a.length;

        int swaps = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swaps++;
                }
            }

        }

        System.out.println("Array is sorted in " +  swaps + " swaps.");
        System.out.println("First Element: " + a[0] );
        System.out.println("Last Element: " + a[n-1]);
    }


}
