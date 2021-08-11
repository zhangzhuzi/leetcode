package com.leetcode.dp;

/**
 * @description: FindGreatestSumOfSubArray
 * @date: 2021/8/11 14:34
 * @author: zsz
 * 连续子数组的最大和
 * {6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] nums) {
        //不能认为0是最小值，因为最大值可能是负数
        int ret = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : nums) {
            sum = sum <= 0 ? val : sum + val;
            ret = Math.max(ret, sum);
        }
        return ret;
    }

    public static void main(String[] args) {
        FindGreatestSumOfSubArray findGreatestSumOfSubArray = new FindGreatestSumOfSubArray();
        int[] nums = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(findGreatestSumOfSubArray.FindGreatestSumOfSubArray(nums));
    }
}
