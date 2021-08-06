package com.leetcode.tree;

import com.leetcode.entity.TreeNode;

import java.util.ArrayList;

/**
 * @description: FindPath
 * @date: 2021/8/6 10:39
 * @author: zsz
 * <p>
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(12);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(7);
        root.left = node;
        root.right = node1;
        node.left = node2;
        node.right = node3;

        findPath(root, 22);
        System.out.println(ret);
    }

    private static ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        backTracking(root, target, new ArrayList<>());
        return ret;
    }

    private static void backTracking(TreeNode root, int target, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;

        if (target == 0 && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(path));
        } else {
            backTracking(root.left, target, path);
            backTracking(root.right, target, path);
        }
        path.remove(path.size() - 1);
    }
}
