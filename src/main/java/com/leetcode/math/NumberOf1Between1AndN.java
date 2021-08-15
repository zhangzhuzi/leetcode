package com.leetcode.math;

import javax.crypto.Cipher;
import java.util.Currency;

/**
 * @Author: ZhangShiZhu
 * @Description:
 * @Date: create in 2021/8/12 21:33
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数
 * 例如，1~13中包含1的数字有1、10、11、12、13因此共出现6次
 */
public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN(int n) {
        int low = 0, cur = n % 10, high = n / 10, digit = 1, ret = 0;
        while (high > 0 || cur > 0) {
            if (cur == 0) {
                ret += high * digit;
            } else if (cur == 1) {
                ret += high * digit + low + 1;
            } else {
                ret += (high + 1) * digit;
            }

            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return ret;
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN number = new NumberOf1Between1AndN();
        System.out.println(number.NumberOf1Between1AndN(13));
    }
}
