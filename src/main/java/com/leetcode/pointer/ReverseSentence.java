package com.leetcode.pointer;

/**
 * @description: ReverseSentence
 * @date: 2021/7/30 11:23
 * @author: zsz
 * <p>
 * 翻转单词顺序列
 * Input:
 * "I am a student."
 * <p>
 * Output:
 * "student. a am I"
 */
public class ReverseSentence {
    public static void main(String[] args) {
        System.out.println(reverseSentence("I am a student."));
    }

    public static String reverseSentence(String str) {
        int n = str.length();
        if (n == 0) {
            return str;
        }

        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                reverse(chars, i, j-1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars,0,n-1);
        return new String(chars);
    }

    private static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i, j);
            i++;
            j--;
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
