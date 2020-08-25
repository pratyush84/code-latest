package com.learn.hackerrank;

import java.util.Arrays;

public class FraudActivity {

    public static void main(String[] args) {
        int[] expArr = new int[]{0,82,180,55,168};
        int trailingDays = 10000;

        System.out.println(activityNotifications(expArr, trailingDays));
    }

    static int activityNotifications(int[] expenditure, int d){
        int arrSize = expenditure.length;

        int notifications = 0;

        if(arrSize > d) {
            for (int i = 0; i < (arrSize - d); i++) {
                int[] subArr = Arrays.copyOfRange(expenditure, i, i + d);
                Arrays.sort(subArr);

                double median = findMedian(subArr);
                if (expenditure[i + d] >= median * 2) {
                    notifications++;
                }
            }
        }
        return  notifications;
    }

    private static double findMedian(int[] arr){
        int size = arr.length;

        if(size % 2 == 0){
            return (arr[size/2] + arr[(size/2) -1])/2.0;
        } else
            return arr[size/2];
    }
}
