package com.leetcode;

import com.leetcode.entity.RandomListNode;

/**
 * @description: RandomListNodeClone
 * @date: 2021/8/4 11:29
 * @author: zsz
 * <p>
 * 复杂链表复制：
 * 1，在每个节点的后面插入复制的节点；
 * 2，对复制节点的random链接进行赋值；
 * 3，拆分复制节点。
 */
public class RandomListNodeClone {
    public RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        //插入新节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        //建立random连接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                //clone指向clone，所以是cur.random.next而不是cur.random
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }

        //拆分
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            //隔位相连，拆分原链表和clone链表
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }
}
