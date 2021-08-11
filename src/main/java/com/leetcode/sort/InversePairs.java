package com.leetcode.sort;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * @description: InversePairs
 * @date: 2021/8/10 16:28
 * @author: zsz
 * <p>
 * 数组中的逆序对
 * <p>
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * <p>
 * 对于50\%50%的数据,size\leq 10^4size≤10^4
 * <p>
 * 对于100\%100%的数据,size\leq 10^5size≤10^5
 */
public class InversePairs {
    private long cnt = 0;
    /**
     * 在这里声明辅助数组，而不是在merge()递归函数里声明。在内部声明会频繁的创建和销毁。
     */
    private int[] temp;

    public int InversePairs(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return (int) (cnt % 1000000007);
    }

    private void mergeSort(int[] nums, int start, int end) {
        //递归结束
        if (end - start < 1) {
            return;
        }
        int middle = start + ((end - start) >> 1);
        //递归
        mergeSort(nums, start, middle);
        mergeSort(nums, middle + 1, end);
        //归并
        merge(nums, start, middle, end);
    }

    private void merge(int[] nums, int start, int middle, int end) {
        int i = start;
        int j = middle + 1;
        //temp数组起始下标
        int k = start;
        while (i <= middle || j <= end) {
            if (i > middle) {
                temp[k] = nums[j++];
            } else if (j > end) {
                temp[k] = nums[i++];
            } else if (nums[i] <= nums[j]) {
                temp[k] = nums[i++];
            } else {
                //nums[i]>nums[j]
                temp[k] = nums[j++];
                // TODO: 2021/8/11 复习，这种部分有序的思想很巧妙
                //nums[i]>nums[j],说明i->middle都大于j
                this.cnt += middle - i + 1;
            }
            k++;
        }

        for (k = start; k <= end; k++) {
            nums[k] = temp[k];
        }
    }
}
