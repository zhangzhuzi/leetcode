package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ZhangShizhu
 */
public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(findNumbersWithSum(nums, 9));
    }

    public static ArrayList<Integer> findNumbersWithSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new ArrayList<>(Arrays.asList(nums[i], nums[j]));
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new ArrayList<>();
    }
}
