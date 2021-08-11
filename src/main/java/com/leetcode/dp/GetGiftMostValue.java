package com.leetcode.dp;

/**
 * @description: GetGiftMostValue
 * @date: 2021/8/11 16:36
 * @author: zsz
 * 礼物的最大价值
 * <p>
 * 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
 */
public class GetGiftMostValue {
    /*public int getMost(int[][] values) {
        if (values.length == 0 || values[0].length == 0) {
            return 0;
        }
        int r = values.length;
        int c = values[0].length;
        //棋盘价值数组
        int[][] val = new int[r][c];
        //初始化val[0][0] - val[0][c-1]
        for (int i = 0; i < c; i++) {
            val[0][i] = (i == 0) ? values[0][0] : values[0][i] + val[0][i - 1];
        }
        //初始化val[1][0] - val[r-1][0]
        for (int i = 1; i < r; i++) {
            val[i][0] = values[i][0] + val[i - 1][0];
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                val[i][j] = Math.max(values[i][j] + val[i][j - 1], values[i][j] + val[i - 1][j]);
            }
        }
        return val[r - 1][c - 1];
    }*/

    public int getMost(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) {
            return 0;
        }
        int c = values[0].length;
        //存储当前行价值
        int[] dp = new int[c];
        for (int[] row : values) {
            //精简后不需要提前初始化第0列
            dp[0] += row[0];
            for (int i = 1; i < c; i++) {
                //dp[i]存储的是r-1行第i个最大价值，dp[i-1]存储的是r行第i-1个最大价值
                dp[i] = Math.max(dp[i], dp[i - 1]) + row[i];
            }
        }
        return dp[c - 1];
    }

    public static void main(String[] args) {
        int[][] values = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        GetGiftMostValue getGiftMostValue = new GetGiftMostValue();
        System.out.println(getGiftMostValue.getMost(values));
    }
}
