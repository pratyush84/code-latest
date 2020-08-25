package com.learn.multipleinheritence;

public interface Parent2 {
    default int sum(int a, int b){
        return a-b;
    }
}
