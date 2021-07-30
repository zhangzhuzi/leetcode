package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: maxInWindows
 * @date: 2021/7/29 17:41
 * @author: zsz
 */
public class maxInWindows {
    public static void main(String[] args) {
        int[] nums = {1, 9, 6, 3, 7, 1, 2, 0, 9};
        System.out.println(maxInWindows(nums, 3));
    }

    public static ArrayList maxInWindows(int[] nums, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > nums.length || size < 1) {
            return ret;
        }
        //构建大根堆
        PriorityQueue<Integer> num = new PriorityQueue<>(Comparator.reverseOrder());
        //存入第一个窗口内数
        for (int i = 0; i < size; i++) {
            num.add(nums[i]);
        }
        ret.add(num.peek());
        for (int i = 0; i < nums.length - size; i++) {
            //删除窗口内过期数
            num.remove(nums[i]);
            //新增窗口内新数
            num.add(nums[i + size]);
            ret.add(num.peek());
        }
        return ret;
    }
}
