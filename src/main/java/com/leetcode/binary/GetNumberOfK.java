package com.leetcode.binary;

/**
 * @description: GetNumberOfK
 * @date: 2021/8/9 10:55
 * @author: zsz
 *
 * 数字在排序数组中出现的次数
 * 二分法
 */
public class GetNumberOfK {

    public int GetNumberOfK(int[] array, int k) {
        //查找第一个k的位置
        int first = binarySearch(array, k);
        //查找k+1的第一个位置，-1即为k的最后一个位置
        int last = binarySearch(array, k + 1);
        return first == array.length || array[first] != k ? 0 : last - first;
    }

    private int binarySearch(int[] nums, int k) {
        //注意h为length而不是length-1，这样当k+1不存在时返回的位置为k+1插入时的位置
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= k) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
