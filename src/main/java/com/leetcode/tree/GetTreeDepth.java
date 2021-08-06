package com.leetcode.tree;

import com.leetcode.entity.TreeNode;

/**
 * @description: getTreeDepth
 * @date: 2021/8/6 15:58
 * @author: zsz
 *
 * 计算树的深度
 */
public class GetTreeDepth {
    public int getTreeDepth(TreeNode root) {
        //return root == null ? 0 : 1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right));
        if (root == null) {
            return 0;
        }
        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        return Math.max(left, right) + 1;
    }

/*    public int depth = 0;
    public void getTreeDepth(TreeNode root, int dep) {
        if (root == null) {
            if (dep > depth) {
                depth = dep;
            }
            return;
        }
        dep++;
        getTreeDepth(root.left, dep);
        getTreeDepth(root.right, dep);
    }*/
}
