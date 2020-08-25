package com.learn.practice;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(findFact(5));
    }
    static double findFact(int n){
        if(n == 0)
            return 1;
        else
            return n * findFact(n-1);
    }


}
