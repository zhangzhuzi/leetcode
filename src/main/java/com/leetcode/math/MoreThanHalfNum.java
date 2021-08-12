package com.leetcode.math;

/**
 * @description: MoreThanHalfNum
 * @date: 2021/8/12 14:23
 * @author: zsz
 *
 * 数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。你可以假设数组是非空的，并且给定的数组总是存在多数元素。1<=数组长度<=50000，0<=数组元素<=10000
 * 示例1
 * 输入：
 * [1,2,3,2,2,2,5,4,2]
 * 返回值：
 * 2
 *
 * 示例2
 * 输入：
 * [3,3,3,3,2,2,2]
 * 返回值：
 * 3
 *
 * 示例3
 * 输入：
 * [1]
 * 返回值：
 * 1
 *
 * 投票问题：时间复杂度为2n，空间复杂度为1
 * 如果使用map存储出现次数，也是2n，但是额外空间复杂度为n
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int[] array) {
        int target = array[0];
        int cnt = 1;
        for (int i = 1; i < array.length; i++) {
            //注意cnt++ 和 ++cnt的区别
            cnt = array[i] == target ? ++cnt : --cnt;
            if (cnt == 0) {
                target = array[i];
                cnt = 1;
            }
        }

        cnt = 0;
        for (int val : array) {
            if (val == target) {
                cnt++;
            }
        }

        return cnt > array.length / 2 ? target : 0;
    }
}
