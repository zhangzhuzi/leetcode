package com.leetcode.sort;

import java.util.Arrays;

/**
 * @description: MergeSort
 * @date: 2021/8/10 17:18
 * @author: zsz
 * <p>
 * 归并排序
 * 时间复杂度为O(nlogn)=拆分时间（logn）+合并时间（每一层都是n）
 */
public class MergeSort {
    public void mergeSort(int[] arr, int start, int end) {
        //分治的结束条件
        if (start >= end) {
            return;
        }
        //保证不溢出取start和end的中位数
        int mid = start + ((end - start) >> 1);
        //递归排序
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        //合并
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int p1 = start;
        int p2 = mid + 1;
        //temp数组下标
        int p = 0;

        //比较start->mid，mid+1->end 两个区间数值，依次存储到temp中
        while (p1 <= mid && p2 <= end) {
            if (arr[p1] > arr[p2]) {
                temp[p++] = arr[p2++];
            } else {
                temp[p++] = arr[p1++];
            }
        }

        //(mid-start)>(end-mid-1)
        while (p1 <= mid) {
            temp[p++] = arr[p1++];
        }
        //(mid-start)<(end-mid-1)
        while (p2 <= end) {
            temp[p++] = arr[p2++];
        }

        //temp排序数组替换原数组start->end位数
        for (int i = 0; i < temp.length; i++) {
            arr[start + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 6, 1, 3, 7, 9, 8, 5};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
