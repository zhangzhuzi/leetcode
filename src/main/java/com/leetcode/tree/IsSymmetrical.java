package com.leetcode.tree;

import com.leetcode.entity.TreeNode;

/**
 * @description: isSymmetrical
 * @date: 2021/8/4 17:32
 * @author: zsz
 */
public class IsSymmetrical {
    public boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetrical(root.left, root.right);
    }

    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }
}
