package com.leetcode.search;

/**
 * @description: HasPath
 * @date: 2021/8/9 14:39
 * @author: zsz
 * <p>
 * 矩阵中的路径：回溯法
 * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向上下左右移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 */
public class HasPath {
    //左、右、下、上
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int rows;
    private int cols;

    public boolean hasPath(String val, int rows, int cols, String path) {
        if (rows == 0 || cols == 0) {
            return false;
        }
        this.rows = rows;
        this.cols = cols;
        //初始化二维数组
        char[] array = val.toCharArray();
        char[][] matrix = buildMatrix(array);
        //标记是否访问过
        boolean[][] marked = new boolean[rows][cols];
        char[] pathList = path.toCharArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backTracking(matrix, pathList, marked, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTracking(char[][] matrix, char[] pathList, boolean[][] marked, int pathLen, int row, int col) {
        if (pathLen == pathList.length) {
            return true;
        }
        if (row < 0 || row >= rows || col < 0 || col >= cols || matrix[row][col] != pathList[pathLen] || marked[row][col]) {
            return false;
        }
        marked[row][col] = true;
        for (int[] n : next) {
            if (backTracking(matrix, pathList, marked, pathLen + 1, row + n[0], col + n[1])) {
                return true;
            }
        }
        marked[row][col] = false;
        return false;
    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = array[index++];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        HasPath solution = new HasPath();
        String val = "ABCESFCSADEE";
        int rows = 3;
        int cols = 4;
        String path = "ABCCED";
        boolean res = solution.hasPath(val, rows, cols, path);
        System.out.println(res);
    }
}
