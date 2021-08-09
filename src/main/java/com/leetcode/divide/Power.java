package com.leetcode.divide;

/**
 * @description: Power
 * @date: 2021/8/9 11:54
 * @author: zsz
 * 数值的整数次方：给定一个 double 类型的浮点数 x和 int 类型的整数 n，求 x 的 n 次方。
 * 分治法
 */
public class Power {
    public double Power(double base, int exponent) {
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double res = pow(base, exponent);
        return isNegative ? 1 / res : res;
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double res = pow(x, n / 2);
        res = res * res;
        if (n % 2 != 0) {
            res *= x;
        }
        return res;
    }
}
