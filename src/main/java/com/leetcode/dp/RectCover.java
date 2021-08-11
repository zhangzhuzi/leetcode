package com.leetcode.dp;

/**
 * @description: rectCover
 * @date: 2021/8/11 11:12
 * @author: zsz
 *
 * 矩形覆盖
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 * f(0) = 0
 * f(1) = 1
 * f(2) = 2
 * f(n) = f(n-1) + f(n-2)
 * 初始有两种情况：
 * f(n-1)代表先覆盖2*1，再覆盖剩余
 * f(n-2)代表先覆盖2*2，再覆盖剩余
 */
public class RectCover {
    public int recover(int n) {
        //注意n<=2而不是n<=1
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
