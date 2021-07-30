package com.leetcode;

/**
 * @description: LeftRotateString
 * @date: 2021/7/30 13:56
 * @author: zsz
 *
 * 将字符串 S 从第 K 位置分隔成两个子字符串，并交换这两个子字符串的位置。
 * Input:
 * S="abcXYZdef"
 * K=3
 *
 * Output:
 * "XYZdefabc"
 */
public class LeftRotateString {
    public static void main(String[] args) {
        System.out.println(leftRotateString(",6", 3));
    }

    public static String leftRotateString(String str, int split) {
        char[] chars = str.toCharArray();
        if (str.length() > split) {
            reverse(chars, 0, split - 1);
            reverse(chars, split, chars.length - 1);
            reverse(chars, 0, chars.length - 1);
        }
        return new String(chars);
    }

    private static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
