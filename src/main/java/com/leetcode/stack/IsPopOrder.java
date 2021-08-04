package com.leetcode.stack;

import java.util.Stack;

/**
 * @description: IsPopOrder
 * @date: 2021/7/29 14:40
 * @author: zsz
 */
public class IsPopOrder {
    public static void main(String[] args) {
        int[] pushSeq = {1,2,3,4,5};
        int[] popSeq = {4,3,5,1,2};
        System.out.println(isPopOrder(pushSeq,popSeq));
    }

    public static boolean isPopOrder(int[] pushSeq, int[] popSeq) {
        Stack<Integer> stack = new Stack<>();
        int length = pushSeq.length;
        for (int pushIndex = 0, popIndex = 0; pushIndex < length; pushIndex++) {
            stack.push(pushSeq[pushIndex]);
            while (!stack.isEmpty() && stack.peek() == popSeq[popIndex] && popIndex < length) {
                stack.pop();
                popIndex++;
            }
        }

        return stack.isEmpty();
    }
}
