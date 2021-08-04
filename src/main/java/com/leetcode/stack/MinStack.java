package com.leetcode.stack;

import java.util.Stack;

/**
 * @description: minStack
 * @date: 2021/7/29 14:25
 * @author: zsz
 */
public class MinStack {
    public static void main(String[] args) {

    }

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
