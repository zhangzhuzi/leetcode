package com.leetcode.tree;

import com.leetcode.entity.TreeNode;

/**
 * @description: ConvertToLink
 * @date: 2021/8/6 13:54
 * @author: zsz
 */
public class ConvertToLink {

    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode convert(TreeNode root) {
        inOrder(root);
        return head;
    }

    // TODO: 2021/8/6 逻辑比较绕，需要复习
    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        //将当前节点左孩子指向前一个节点（注意是双向链表，最左孩子的前驱结点为自己）
        node.left = pre;
        if (pre != null) {
            //如果pre节点不为空，使pre节点指向当前节点
            pre.right = node;
        }
        //遍历完一个节点后，pre结点切换为当前节点
        pre = node;
        if (head == null) {
            //将head节点赋值为最左孩子结点，即链表的第一个节点
            head = node;
        }
        inOrder(node.right);
    }
}
