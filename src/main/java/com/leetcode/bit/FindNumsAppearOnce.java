package com.leetcode.bit;

/**
 * @Author: ZhangShiZhu
 * @Description:
 * @Date: create in 2021/8/15 17:54
 * 数组中只出现一次的两个数字
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 示例1
 * 输入：
 * [1,4,1,6]
 * 返回值：
 * [4,6]
 * 说明：
 * 返回的结果中较小的数排在前面
 */
public class FindNumsAppearOnce {
    public int[] FindNumsAppearOnce(int[] nums) {
        int[] res = new int[2];
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        if (res[0] > res[1]) {
            swap(res);
        }
        return res;
    }

    private void swap(int[] nums) {
        int t = nums[0];
        nums[0] = nums[1];
        nums[1] = t;
    }
}
