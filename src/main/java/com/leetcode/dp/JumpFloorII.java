package com.leetcode.dp;

/**
 * @description: JumpFloorII
 * @date: 2021/8/11 11:45
 * @author: zsz
 * 变态跳台阶
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * f(0) = 0
 * f(1) = 1
 * f(2) = 2
 * f(3) = f(2) + f(1) + 1
 * f(4) = f(3) + f(2) + f(1) + 1
 */
public class JumpFloorII {
    public int jumpFloorII(int n) {
        if (n <= 2) {
            return n;
        }
        int[] jum = new int[n + 1];
        jum[1] = 1;
        jum[2] = 2;
        for (int i = 3; i <= n; i++) {
            int temp = 1;
            for (int j = 1; j < i; j++) {
                temp += jum[j];
            }
            jum[i] = temp;
        }
        return jum[n];
    }

    public static void main(String[] args) {
        JumpFloorII jumpFloorII = new JumpFloorII();
        System.out.println(jumpFloorII.jumpFloorII(10));
    }
}
