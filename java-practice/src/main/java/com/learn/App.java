package com.learn;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
      /*  int[] input = new int[]{2,7,11,15};
        int target = 6;
        int[] result = twoSum(input, target);
        System.out.println(result[0] + " " + result[1]);

        ListNode list11 = new ListNode(2);
        ListNode list12 = new ListNode(4);
        ListNode list13 = new ListNode(3);

        list11.next = list12;
        list12.next = list13;*/
        double a = 10.0 / 3.0;

        System.out.println(a);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int num1 = calcNum(l1);
        int num2 = calcNum(l2);

        int sum = num1 + num2;


        return l1;
    }



    private static int calcNum(ListNode listNode){
        ListNode nextNode = listNode.next;
        int val = listNode.val;

        int exp = 1;

        while(nextNode != null){
            val += (nextNode.val + Math.pow(10, exp) );
            nextNode = nextNode.next;
            exp ++;
        }

        return  val;
    }

    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
//    public static int[] twoSum(int[] nums, int target){
//        int[] returnArr = new int[2];
//        boolean flag = false;
//        for(int i = 0; i < nums.length ; i++){
//           for (int j = i+1; j < nums.length ; j++) {
//               if(nums[i] + nums[j] == target){
//                   returnArr[0] = i;
//                   returnArr[1] = j;
//                   flag = true;
//               }
//               if(flag) {
//                   break;
//               }
//           }
//           if(flag){
//               break;
//           }
//       }
//        return  returnArr;
//    }
}
