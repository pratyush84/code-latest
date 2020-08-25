package com.learn;

public class DavisStairs {
    public static void main(String[] args) {
        System.out.println(stepM(new int[8], 7));
    }
    static int stepM(int[] memo, int n){
        if(memo[n] != 0){
            return memo[n];
        }

        int result;
        if(n == 0 || n==1){
            result =  1;
        } else if(n==2){
            result =  2;
        } else{
            result =  stepM(memo,n-1) + stepM(memo,n-2) +stepM(memo,n-3);
        }

        memo[n] = result;
        return result;
    }

}
