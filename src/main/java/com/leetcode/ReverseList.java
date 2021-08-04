package com.leetcode;

import com.leetcode.entity.ListNode;

/**
 * @description: ReverseList
 * @date: 2021/8/4 10:42
 * @author: zsz
 * <p>
 * 反转链表
 */
public class ReverseList {

    //递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        //取消当前节点指向下一个节点
        head.next = null;
        ListNode newHead = reverseList(next);
        //下一个节点指向当前节点
        next.next = head;
        return newHead;
    }


    //非递归：头插法
    public ListNode reverseList2(ListNode head) {
        //虚拟头结点
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            //将新插入的节点指向原来的第一个节点
            head.next = newHead.next;
            //将头结点指向新插入的节点
            newHead.next = head;
            head = next;
        }
        return newHead;
    }
}
