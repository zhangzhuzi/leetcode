package com.leetcode.entity;

/**
 * @description: TreeLinkNode
 * @date: 2021/8/4 15:56
 * @author: zsz
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left = null;
    public TreeLinkNode right = null;
    public TreeLinkNode next = null; // 指向父结点的指针

    public TreeLinkNode(int val) {
        this.val = val;
    }
}
