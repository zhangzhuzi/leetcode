package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @description: getMedian
 * @date: 2021/7/29 16:11
 * @author: zsz
 */
public class GetMedian {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Insert(new Random().nextInt(100));
        }
        System.out.println(GetMedian());
    }

    /**
     * 大顶堆，存储左半边元素
     */
    private static PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    /**
     * 小顶堆，存储右半边元素
     */
    private static PriorityQueue<Integer> right = new PriorityQueue<>();

    static int N = 0;

    public static void Insert(Integer val) {
        /* 插入要保证两个堆存于平衡状态 */
        if (N % 2 == 0) {
            /* N 为偶数的情况下插入到右半边。
             * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
             * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边 */
            left.add(val);
            right.add(left.poll());
        } else {
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }

    public static Double GetMedian() {
        if (N % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return (double) right.peek();
        }
    }
}
