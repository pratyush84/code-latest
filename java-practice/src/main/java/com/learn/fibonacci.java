package com.learn;

import java.math.BigInteger;

public class fibonacci {
    public static void main(String[] args) {
        int limit = 100000;
//        System.out.println(fibo(limit));
        System.out.println(fibLin(limit));
//        System.out.println(fibMemo(limit, new BigInteger[limit+1] ));
    }

    public static int fibo(int limit){
        if(limit <= 1){
            return limit;
        }
        else{
            return fibo(limit-1)+ fibo(limit-2);
        }
    }

    public static BigInteger fibLin(int limit){
        if(limit <= 1){
            return BigInteger.valueOf(1);
        }
        BigInteger first = BigInteger.ZERO;
        BigInteger second = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < limit -1; i++) {
            sum = first.add(second);
            first = second;
            second = sum;
        }
        return sum;
    }

    public static BigInteger fibMemo(int limit, BigInteger[] memo){
        if(memo[limit] != null){
            return memo[limit];
        }
        BigInteger result;
        if(limit <= 1){
            result =  BigInteger.ONE;
        } else{
            result = fibMemo(limit-1,memo).add(fibMemo(limit-2,memo));
        }
        memo[limit] = result;

        return result;
    }
}


//T(n) = T(n-1) + T(n-2)
//T(0) = 1
//T(1) = 1
//T(n-1) = T(n-2) +T(n-3)
//T(n-2) = T(n-3) + T(n-4)
//T(n-3) = T(n-4) + T(n-5)
//T(n-k) = T(n-k-1) + T(n-k-2)
//T(n) = T(n-2) +2T(n-3) + T(n-4)
//     = T(n-3) + T(n-4) + 2T(n-3) + T(n-4)
//     = 3T(n-3) + 2T(n-4)
//     = 3(T(n-4) + T(n-5)) + 2(T(n-5) + T(n-6))
//     =3T(n-4) +5T(n-5) + 2T(n-6)
//     =3(T(n-5) + T(n-6)) + 5T(n-5) + 2T(n-6)
//     =8T(n-5) + 5T(n-6)
//T(n) = 2T(n-2)+T(n-3)
//     = 3T(n-3) + T(n-4)
//     = kT(n-k) + T(n-k-1)
// n-k = 0 , n = k
// T(n) = nT(0)