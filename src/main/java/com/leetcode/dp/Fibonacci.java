package com.leetcode.dp;

/**
 * @description: Fibonacci
 * @date: 2021/8/11 10:46
 * @author: zsz
 *
 * 求斐波那契数列的第 n 项，n <= 39。
 * f(0) = 0
 * f(1) = 1
 * f(n) = f(n-1) + f(n-2)
 */
public class Fibonacci {

    /*//递归
    public int fibonacci(int n){
        if (n<=1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }*/

    //动态规划，缓存之前的计算结果，避免重复计算已经计算过的值
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        //0 ~ n+1，共n+1个
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    /*//动态规划优化，因为只需要求n，那么缓存n-1和n-2位数即可
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int pre2 = 0;
        int pre1 = 1;
        int pre = 0;
        for (int i = 2; i <= n; i++) {
            pre = pre1 + pre2;
            pre2 = pre1;
            pre1 = pre;
        }
        return pre;
    }*/

    /*//还有一种实现把所有值在初始化时计算出来，这样后续取值只是从数组里取值，时间和空间复杂度都为O(1)
    int[] fib = new int[40];
    public Fibonacci(){
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= 39; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
    }*/

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibonacci(39));
    }
}
