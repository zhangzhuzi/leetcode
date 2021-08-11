package com.leetcode.dp;

/**
 * @description: JumpFloor
 * @date: 2021/8/11 11:34
 * @author: zsz
 * 跳台阶
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *  * f(0) = 0
 *  * f(1) = 1
 *  * f(2) = 2
 *  * f(n) = f(n-1) + f(n-2)
 *  * 初始有两种情况：
 *  * f(n-1)代表先跳1个台阶，再跳剩余台阶
 *  * f(n-2)代表先跳2个台阶，再跳剩余台阶
 */
public class JumpFloor {
    public int jumpFloor(int n) {
        if (n <= 2) {
            return n;
        }
        int pre2 = 1;
        int pre1 = 2;
        int pre = 3;
        for (int i = 3; i <= n; i++) {
            pre = pre1 + pre2;
            pre2 = pre1;
            pre1 = pre;
        }
        return pre;
    }
}
