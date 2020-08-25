package com.learn.StacksQueues;

import java.util.Stack;

public class ReverseWord {
    public static void main(String[] args) {
        System.out.println(reverse("pratyush"));
    }

    static String reverse(String word){
        int len = word.length();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            stack.push(ch);
        }
        String output = "";

        while (!stack.isEmpty()){
            char ch = stack.pop();
            output = output + ch;
        }
        return output;
    }
}
