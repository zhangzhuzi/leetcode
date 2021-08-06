package com.leetcode.tree;

/**
 * @description: VerifySquenceOfBST
 * @date: 2021/8/6 9:41
 * @author: zsz
 * <p>
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。
 *
 * 例如，下图是后序遍历序列 1,3,2 所对应的二叉搜索树。
 */
public class VerifySquenceOfBST {
    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int first, int last) {
        //递归终点
        if (last - first <= 1) {
            return true;
        }
        int rootVal = sequence[last];
        int curIndex = first;
        //寻找左子树与右子树的分界值
        while (curIndex < last && sequence[curIndex] <= rootVal) {
            curIndex++;
        }

        // 二叉搜索树：右子树的值>=左子树
        for (int i = curIndex; i < last; i++) {
            if (sequence[i] < last) {
                return false;
            }
        }
        return verify(sequence, first, curIndex - 1) && verify(sequence, curIndex, last - 1);
    }
}
