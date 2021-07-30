package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: twoSum
 * @date: 2020/6/5 8:58
 * @author: zsz
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    public static void main(String[] args) {
        //目标数组
        int[] nums = {2, 7, 11, 15};
        //将遍历过得目标数组key=数组值，value=下标存储到map中
        Map<Integer, Integer> numsMap = new HashMap<>(nums.length);
        //目标值和
        int target = 9;
        //目标值下标
        int[] index = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (numsMap.containsKey(target - current)) {
                index[0] = numsMap.get(target - current);
                index[1] = i;
                break;
            }
            //注意：一定要在判断后添加，否则会重复使用同一个元素
            numsMap.put(nums[i], i);
        }


        System.out.println(index.toString());
    }
}
