package com.learn.functional.udemy;

import java.util.Comparator;

public class LengthDecComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if(o2.length() > o1.length())
            return 1;
        else if(o2.length() < o1.length())
            return -1;
        else return 0;
    }
}
