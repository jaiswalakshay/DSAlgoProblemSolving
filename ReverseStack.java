package com.akshay;

import java.util.Stack;

public class ReverseStack {
    public void reverse(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int val = stack.pop();
            reverse(stack);
            insertAtBottom(stack,val);
        }
    }

    private void insertAtBottom(Stack<Integer> stack , int val){
        if(stack.isEmpty()){
            stack.push(val);
        }else{
            int x = stack.pop();
            insertAtBottom(stack,val);
            stack.push(x);
        }
    }

    public static void main(String[] args) {
        ReverseStack rs = new ReverseStack();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Before:" + stack);
        rs.reverse(stack);
        System.out.println("After:" + stack);
    }
}
