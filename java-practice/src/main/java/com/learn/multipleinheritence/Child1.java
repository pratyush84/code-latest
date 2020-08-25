package com.learn.multipleinheritence;

public interface Child1 extends Parent1 , Parent2 {

    @Override
    default int sum(int a, int b) {
        return 0;
    }
}
