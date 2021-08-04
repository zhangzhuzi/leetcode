package com.leetcode.tree;

import com.leetcode.entity.TreeNode;

/**
 * @description: MirrorTree
 * @date: 2021/8/4 17:18
 * @author: zsz
 * 二叉树镜像
 */
public class MirrorTree {
    public TreeNode mirror(TreeNode root) {
        if (root == null) {
            return null;
        }

        swap(root);
        mirror(root.left);
        mirror(root.right);
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
