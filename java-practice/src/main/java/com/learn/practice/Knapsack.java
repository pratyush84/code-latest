package com.learn.practice;

import java.util.Arrays;

public class Knapsack {
    static int[][] matrix = new int[5][8];
    public static void main(String[] args) {
        int[] wt = new int[] {1,3,4,5};
        int[] val = new int[] {1,4,5,7};
        int cap = 7;
        int size = wt.length;

        System.out.println(knapSack(wt,val,cap,size));
        System.out.println(Arrays.toString(matrix[1]));
    }

    static int knapSack(int[] wt, int[] val, int cap, int size){

        if(cap == 0 || size == 0){
            return 0;
        }

    /*    if(matrix[size][cap] != 0 ){
            return matrix[size][cap];
        }*/

        if(wt[size-1] <= cap){
//            matrix[size][cap] =  Math.max(val[size - 1] + knapSack(wt,val,cap-wt[size-1],size-1),
//                    knapSack(wt,val,cap,size-1));
//            return matrix[size][cap];
            return Math.max(val[size - 1] + knapSack(wt,val,cap-wt[size-1],size-1),
                    knapSack(wt,val,cap,size-1));
        } else {
           /* matrix[size][cap] = knapSack(wt, val, cap, size - 1);
            return matrix[size][cap];*/

            return knapSack(wt, val, cap, size - 1);
        }
    }
}
