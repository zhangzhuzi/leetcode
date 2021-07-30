package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: lengthOfLongestSubstring
 * @date: 2020/6/9 8:44
 * @author: zsz
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * public int lengthOfLongestSubstring(String s) {
 *         int n = s.length(), ans = 0;
 *         Map<Character, Integer> map = new HashMap<>();
 *         for (int start = 0,end = 0; end < n; end++) {
 *             char alpha = s.charAt(end);
 *             if (map.containsKey(alpha)) {
 *                 start = Math.max(map.get(alpha), start);
 *             }
 *             ans = Math.max(ans, end - start + 1);
 *             map.put(s.charAt(end), end + 1);
 *         }
 *         return ans;
 *     }
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }

        //滑动窗口 abcabcbb
        Map<Character, Integer> map = new HashMap<>();
        //最大长度
        int ans = 0;

        //start->滑动窗口起始位置，end->滑动窗口结束位置
        for (int start = 0, end = 0; end < s.length(); end++) {

            Character alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                //起始位置后移(Math.max注意不要遗忘)
                start = Math.max(start, map.get(alpha));
            }

            //Math.max注意不要遗忘
            //下标+1，长度+1
            map.put(alpha, end + 1);
            ans = Math.max(ans, (end - start + 1));
        }
        return ans;
    }
}
