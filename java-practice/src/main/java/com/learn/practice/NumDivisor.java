package com.learn.practice;

public class NumDivisor {
    public static void main(String[] args) {
        System.out.println(numDiv(291));
    }
    public static int numDiv(int num){
        int count = 0;
        for (int i = 1; i <= num/2 ; i++) {
            if(num%i == 0){
                System.out.println(i);
                count++;
            }
        }
        return count + 1;
    }
}
