package com.leetcode.dp;

import java.util.*;

/**
 * @description: DicesSum
 * @date: 2021/8/12 9:22
 * @author: zsz
 * <p>
 * n 个骰子的点数
 * 扔 n 个骰子，向上面的数字之和为 S。给定 n，请列出所有可能的 S 值及其相应的概率。
 * 1 <= s <= 6
 */
public class DicesSum {
    /*public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        List retList = new ArrayList();
        if (n == 0) {
            return retList;
        }
        Map<Integer, Double> rateMap = new HashMap<>();
        rateMap.put(1, 0.17);
        rateMap.put(2, 0.17);
        rateMap.put(3, 0.17);
        rateMap.put(4, 0.17);
        rateMap.put(5, 0.17);
        rateMap.put(6, 0.17);
        if (n == 1) {
            retList.add(rateMap);
            return retList;
        }

        Map<Integer, Double> retMap = rateMap;
        for (int i = 2; i <= n; i++) {
            Map<Integer, Double> tempMap = new HashMap<>();
            for (int j = 1; j <= 6; j++) {
                for (Integer key : retMap.keySet()) {
                    tempMap.put(key + j, tempMap.containsKey(key + j) ? tempMap.get(key + j) + retMap.get(key) * 0.17 : retMap.get(key) * 0.17);
                }
            }
            retMap = tempMap;
        }
        retList.add(retMap);
        return retList;
    }*/

    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        final int face = 6;
        //点数最大为pointNum，但是点数列举最多为6^n存在重复点数
        final int pointNum = face * n;
        long[][] dp = new long[n + 1][pointNum + 1];

        for (int i = 1; i <= face; i++) {
            //第一个骰子1-6各出现1次，6种情况
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= pointNum; j++) {
                for (int k = 1; k <= face && k <= j; k++) {
                    //上一枚骰子只要比j点数<=6的，这枚骰子1~6的时候点数和可能相等
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++) {
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));
        }
        return ret;
    }

    public static void main(String[] args) {
        DicesSum dicesSum = new DicesSum();
        System.out.println(dicesSum.dicesSum(2));
    }
}
