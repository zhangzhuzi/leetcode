package com.leetcode.tree;

import com.leetcode.entity.TreeNode;

/**
 * @description: findKthTree
 * @date: 2021/8/6 15:25
 * @author: zsz
 */
public class FindKthTree {
    private TreeNode ret;
    private int cnt = 0;

    public TreeNode findKthTree(TreeNode root, int target) {
        inOrder(root, target);
        return ret;
    }

    private void inOrder(TreeNode node, int target) {
        if (node == null || cnt >= target) {
            return;
        }
        inOrder(node.left, target);
        // TODO: 2021/8/6 关于cnt的控制，这块需要复习，找不准在哪加
        cnt++;
        if (cnt == target) {
            ret = node;
        }
        inOrder(node.right, target);
    }
}
