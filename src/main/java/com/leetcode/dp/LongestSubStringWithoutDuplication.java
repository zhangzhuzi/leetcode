package com.leetcode.dp;

import sun.rmi.runtime.Log;

import java.util.Arrays;

/**
 * @Author: ZhangShiZhu
 * @Description:
 * @Date: create in 2021/8/11 19:48
 * <p>
 * 最长不含重复字符的子字符串
 * <p>
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。例如对于 arabcacfr，
 * 最长不含重复字符的子字符串为 acfr，长度为 4。
 */
public class LongestSubStringWithoutDuplication {
    public int longestSubStringWithoutDuplication(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int maxLen = 0;
        int curLen = 0;

        //辅助数组，存储元素下标
        int[] index = new int[26];
        Arrays.fill(index, -1);
        for (int curIdx = 0; curIdx < str.length(); curIdx++) {
            int c = str.charAt(curIdx) - 'a';
            int preIdx = index[c];
            if (preIdx == -1) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = curIdx - preIdx;
            }
            index[c] = curIdx;
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubStringWithoutDuplication  longestSubStringWithoutDuplication=new LongestSubStringWithoutDuplication();
        System.out.println(longestSubStringWithoutDuplication.longestSubStringWithoutDuplication("arabracfr"));
    }
}
