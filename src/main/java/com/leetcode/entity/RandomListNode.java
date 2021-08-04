package com.leetcode.entity;

/**
 * @description: RandomListNode
 * @date: 2021/8/4 11:27
 * @author: zsz
 *
 * 复杂链表
 */
public class RandomListNode {
    public int label;
    public RandomListNode next = null;
    public RandomListNode random = null;

    public RandomListNode(int label) {
        this.label = label;
    }

}
