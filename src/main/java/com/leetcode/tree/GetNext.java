package com.leetcode.tree;

import com.leetcode.entity.TreeLinkNode;

/**
 * @description: GetNext
 * @date: 2021/8/4 16:06
 * @author: zsz
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回 。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 中序遍历：左孩子、根节点、右孩子
 * 下一个节点：
 * 1，存在右孩子：下一个节点为右孩子下节点的最左节点
 * 2，不存在右孩子：下一个节点为父节点（若存在，且当前节点为父节点的左孩子）
 */
public class GetNext {
    public TreeLinkNode getNext(TreeLinkNode pNode){
        if (pNode.right!=null){
            TreeLinkNode node = pNode.right;
            while (node.left!=null){
                node = node.left;
            }
            return node;
        }else {
            while (pNode.next!=null){
                TreeLinkNode next = pNode.next;
                if (next.left==pNode){
                    return next;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }
}
