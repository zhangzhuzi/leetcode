package com.leetcode.tree;

import com.leetcode.entity.TreeNode;

/**
 * @description: IsBalanced_Solution
 * @date: 2021/8/6 17:17
 * @author: zsz
 */
public class isBalancedSolution {
    private boolean isBalance = true;

    public boolean isBalance(TreeNode root) {
        height(root);
        return isBalance;
    }

    private int height(TreeNode root) {
        if (root == null || !isBalance) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalance = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
