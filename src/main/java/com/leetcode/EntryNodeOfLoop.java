package com.leetcode;

import com.leetcode.entity.ListNode;

/**
 * @description: EntryNodeOfLoop
 * @date: 2021/8/4 9:54
 * @author:
 * 一个链表中包含环，请找出该链表的环的入口结点。要求不能使用额外的空间。
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop (ListNode pHead){
        if (pHead==null||pHead.next==null){
            return null;
        }
        ListNode slow = pHead,fast = pHead;
        //寻找相遇点
        do {
            fast = fast.next.next;
            slow = slow.next;
        }while (slow!=fast);

        //寻找入口
        fast = pHead;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
