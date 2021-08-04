package com.leetcode.tree;

import com.leetcode.entity.TreeNode;
import jdk.nashorn.internal.ir.ReturnNode;

/**
 * @description: HasSubtree
 * @date: 2021/8/4 16:32
 * @author: zsz
 * <p>
 * 树的子结构:
 * 1，相同的树
 * 2，左子树包含
 * 3，右子树包含
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubTreeWithRoot(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isSubTreeWithRoot(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSubTreeWithRoot(root1.left, root2.left) && isSubTreeWithRoot(root1.right, root2.right);
    }
}
