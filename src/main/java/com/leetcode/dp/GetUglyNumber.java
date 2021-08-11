package com.leetcode.dp;

import javax.sound.midi.Soundbank;

/**
 * @Author: ZhangShiZhu
 * @Description:
 * @Date: create in 2021/8/11 21:51
 * 丑数
 * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。习惯上我们把 1 当做是第一个丑数。求按从小到大的顺序的第 N 个丑数。
 */
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        int[] dp = new int[index];
        dp[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < index; i++) {
            int num2 = dp[index2] * 2;
            int num3 = dp[index3] * 3;
            int num5 = dp[index5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));
            //注意：这不能用else if连接，否则当num2/num3/num5相等的时候，index只会有一个增加，导致重复出现一个丑数
            if (dp[i] == num2) {
                index2++;
            }
            if (dp[i] == num3) {
                index3++;
            }
            if (dp[i]==num5){
                index5++;
            }
        }
        return dp[index - 1];
    }

    public static void main(String[] args) {
        GetUglyNumber getUglyNumber = new GetUglyNumber();
        System.out.println(getUglyNumber.GetUglyNumber_Solution(7));
    }


}
