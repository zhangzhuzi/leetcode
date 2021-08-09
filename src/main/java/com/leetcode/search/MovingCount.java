package com.leetcode.search;

/**
 * @description: MovingCount
 * @date: 2021/8/9 15:41
 * @author: zsz
 *
 * 机器人的运动范围
 */
public class MovingCount {
    private int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int cnt = 0;
    private int rows;
    private int cols;
    //数位和上限
    private int threshold;
    //坐标数组，数组值为数位和
    private int[][] digitSum;

    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        //初始化坐标数组
        initDigitSum();
        //标记数组
        boolean[][] marked = new boolean[rows][cols];
        dfs(marked, 0, 0);
        return cnt;
    }

    private void dfs(boolean[][] marked, int row, int col) {
        //>=，>的话会数组越界
        if (row < 0 || row >= rows || col < 0 || col >= cols || marked[row][col]) {
            return;
        }
        marked[row][col] = true;
        if (this.digitSum[row][col] > this.threshold) {
            return;
        }
        cnt++;
        for (int[] n : next) {
            dfs(marked, row + n[0], col + n[1]);
        }
    }

    private void initDigitSum() {
        int[] digitSumOne = new int[Math.max(rows, cols)];
        for (int i = 0; i < digitSumOne.length; i++) {
            int n = i;
            while (n > 0) {
                digitSumOne[i] += n % 10;
                n = n / 10;
            }
        }
        this.digitSum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
            }
        }
    }
}
