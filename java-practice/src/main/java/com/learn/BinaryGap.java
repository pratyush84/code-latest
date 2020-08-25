package com.learn;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

    import java.util.ArrayList;
    import java.util.List;

public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(largestBinaryGap(32));
    }

    private static int largestBinaryGap(int number){

        List<Integer> positionList = new ArrayList<>();

        String binaryString = Integer.toBinaryString(number);
        System.out.println("Binary Representation: " +  binaryString);
        char[] chars = binaryString.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '1'){
                positionList.add(i);
            }
        }

        int largestDiff = findLargestDiff(positionList);

        if(largestDiff > 0){
            return largestDiff - 1;
        } else
            return largestDiff;
    }

    private static int findLargestDiff(List<Integer> inputList){
        int largest = 0;
        for (int i = 0; i <= inputList.size() - 2; i++) {
            int first = inputList.get(i);
            int second = inputList.get(i+1);

            int diff = second - first;
            if(diff > largest){
                largest = diff;
            }
        }
        return largest;
    }
}
