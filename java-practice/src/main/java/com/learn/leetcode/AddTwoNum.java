package com.learn.leetcode;

import com.learn.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddTwoNum {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();

        ListNode l11 = new ListNode(3);
        ListNode l12 = new ListNode(4,l11);
        ListNode l13 = new ListNode(2, l12);

        ListNode l21 = new ListNode(4);
        ListNode l22 = new ListNode(6, l21);
        ListNode l23 = new ListNode(5, l22);

        addTwoNumbers(l13,l23);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        int num1 = 0;
        int num2 = 0;

        while(l1.getNext() != null){
            num1 += (l1.getVal() * Math.pow(10, --len1));
            l1 = l1.getNext();
        }

        while(l2.getNext() != null){
            num2 += (l2.getVal() * Math.pow(10, --len2));
            l2 = l2.getNext();
        }

        int sum = num1 + num2;
        return new ListNode(sum);
    }

    public static int getLength(ListNode l1){
        int len = 0;
        while(l1.getNext() != null){
            len++;
            l1 = l1.getNext();
        }

        return len+1;
    }

    public static ListNode reverseList(ListNode l1){
        ListNode node = new ListNode();
        while(l1.getNext() != null){

        }

        return node;
    }


}
