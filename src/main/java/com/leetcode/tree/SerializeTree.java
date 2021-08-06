package com.leetcode.tree;

import com.leetcode.entity.TreeNode;

/**
 * @description: SerializeTree
 * @date: 2021/8/6 14:45
 * @author: zsz
 */
public class SerializeTree {

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

        System.out.println(serialize(root));
    }

    private String deserializeStr;

    public static String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        //前序遍历
        return root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }

    public TreeNode deSerialize(String str) {
        deserializeStr = str;
        return deSerialize();
    }

    public TreeNode deSerialize() {
        //树还原成功
        if (deserializeStr.length() == 0) {
            return null;
        }
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        //到达叶子节点，结束递归
        if (node.equals("#")) {
            return null;
        }
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = deSerialize();
        t.right = deSerialize();
        return t;
    }
}
