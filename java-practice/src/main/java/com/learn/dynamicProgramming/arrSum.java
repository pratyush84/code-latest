package com.learn.dynamicProgramming;

public class arrSum {

    static int[][] matrix = new int[100][100];

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(arrSumTopDown(new int[]{2,4,6,10,19}, 90,5));
        long endTime = System.nanoTime();
        System.out.println("Time taken - "+ (endTime-startTime));
    }

    static int arrSumTopDown(int[] val, int target, int size){
        int[][] t = new int[size+1][target+1];
        for (int i = 0; i <  size + 1 ; i++) {
            t[i][0] = 1;
        }

        for (int i = 1; i < size+1; i++) {
            for (int j = 1; j < target+1; j++) {
                if(val[i-1] <= j){
                    t[i][j] = t[i-1][j - val[i-1]] + t[i-1][j];
                } else
                    t[i][j] = t[i-1][j];
            }
        }

        return t[size][target];
    }

    static int arrSumMemo(int[] val, int target, int size){
        if(target == 0)
            return 1;

        if(size == 0){
            return 0;
        }

        if(matrix[size][target] != 0){
            return matrix[size][target];
        }

        if(val[size - 1] <= target){
            matrix[size][target] =  arrSumRecursive(val,target - val[size-1], size-1) + arrSumRecursive(val,target, size-1);
            return matrix[size][target];
        } else {
            matrix[size][target] =  arrSumRecursive(val, target, size - 1);
            return matrix[size][target];
        }

    }

    static int arrSumRecursive(int[] val, int target, int size){
        if(target == 0)
            return 1;

        if(size == 0){
            return 0;
        }

        if(val[size - 1] <= target){
            return arrSumRecursive(val,target - val[size-1], size-1) + arrSumRecursive(val,target, size-1);
        } else
            return arrSumRecursive(val,target,size-1);

    }
}
