package com.leetcode.sort;

import javax.sound.midi.Soundbank;

/**
 * @description: ReOrderArray
 * @date: 2021/8/10 9:46
 * @author: zsz
 *
 * 调整数组顺序使奇数位于偶数前面
 * 需要保证奇数和奇数，偶数和偶数之间的相对位置不变，这和书本不太一样。例如对于 [1,2,3,4,5]，调整后得到 [1,3,5,2,4]，而不能是 {5,1,3,4,2} 这种相对位置改变的结果。
 */
public class ReOrderArray {
    public int[] reOrderArray(int[] array) {
        //奇数从首部开始添加，偶数从尾部开始添加
        if (array.length < 2) {
            return array;
        }
        int[] ret = new int[array.length];
        int head = 0, tail = array.length - 1;
        int i = 0, j = array.length - 1;
        while (i <= array.length - 1 || j >= 0) {
            if (i <= array.length - 1 && array[i] % 2 == 1) {
                ret[head] = array[i];
                head++;
            }

            if (j >= 0 && array[j] % 2 == 0) {
                ret[tail] = array[j];
                tail--;
            }
            i++;
            j--;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        ReOrderArray reOrderArray = new ReOrderArray();
        System.out.println(reOrderArray.reOrderArray(array));
    }
}
