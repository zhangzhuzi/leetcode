package com.leetcode.tree;

import com.leetcode.entity.TreeNode;

/**
 * @description: lowestCommonAncestor
 * @date: 2021/8/6 17:37
 * @author: zsz
 */
public class LowestCommonAncestor {
    //二叉查找树
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if (root==null){
            return null;
        }
        if (root.val<p.val&&root.val<q.val){
            lowestCommonAncestor(root.right,p,q);
        }
        if (root.val>p.val&&root.val>q.val){
            lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }


    //普通二叉树：分别查找左子树和右子树是否包含，若p和q在两个子树中，说明根节点是最低公共祖先
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        return left == null ? right : right == null ? left : root;
    }
}
