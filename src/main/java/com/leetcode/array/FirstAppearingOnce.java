package com.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: FirstAppearingOnce
 * @date: 2021/7/29 17:07
 * @author: zsz
 */
public class FirstAppearingOnce {
    public static void main(String[] args) {
        String str = "hello worhe!";
        StringBuffer cout = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            insert(str.charAt(i));
            cout.append(findAppearingOnce());
        }
        System.out.println(cout.toString());
    }

    private static int[] cnts = new int[128];
    private static Queue<Character> queue = new LinkedList<>();

    public static void insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }

    public static char findAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
