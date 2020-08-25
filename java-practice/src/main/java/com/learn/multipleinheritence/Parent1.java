package com.learn.multipleinheritence;

public interface Parent1 {
     int num = 0;
      int multiply(int a, int b);
    default int sum(int a, int b) {
        return a+b;
    }
}
