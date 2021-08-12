package com.leetcode.dp;

import java.util.Arrays;

/**
 * @description: Multiply
 * @date: 2021/8/12 13:54
 * @author: zsz
 * <p>
 * 构建乘积数组
 * <p>
 * 给定一个数组 A[0, 1,..., n-1]，请构建一个数组 B[0, 1,..., n-1]，其中 B 中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。要求不能使用除法。
 */
public class Multiply {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= A[i], i++) {
            B[i] = product;
        }
        for (int i = n - 1, product = 1; i >= 0; product *= A[i], i--) {
            B[i] *= product;
        }
        return B;
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(multiply.multiply(A)));
    }
}
