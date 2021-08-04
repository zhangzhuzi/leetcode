package com.leetcode.linklist;

import com.leetcode.entity.ListNode;

/**
 * @description: addTwoNumbers
 * @date: 2020/6/5 9:24
 * @author: zsz.
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 *
 *  ListNode dummyHead = new ListNode(0);
 *     ListNode p = l1, q = l2, curr = dummyHead;
 *     int carry = 0;
 *     while (p != null || q != null) {
 *         int x = (p != null) ? p.val : 0;
 *         int y = (q != null) ? q.val : 0;
 *         int sum = carry + x + y;
 *         carry = sum / 10;
 *         curr.next = new ListNode(sum % 10);
 *         curr = curr.next;
 *         if (p != null) p = p.next;
 *         if (q != null) q = q.next;
 *     }
 *     if (carry > 0) {
 *         curr.next = new ListNode(carry);
 *     }
 *     return dummyHead.next;
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        l1.next = node2;
        node2.next = node2;

        ListNode l2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(4);
        l2.next = node3;
        node3.next = node4;

        addTwoNumbers(l1, l2);
    }

    /**
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //结果的头节点
        ListNode head = new ListNode(0);
        ListNode result = head;
        //进位值
        int plus = 0;
        while (l1 != null || l2 != null) {
            int l1CurrValue = (l1 != null) ? l1.val : 0;
            int l2CurrValue = (l2 != null) ? l2.val : 0;

            int sum = l1CurrValue + l2CurrValue + plus;
            //整数位为当前值
            plus = sum / 10;
            //余数为进位值
            int curr = sum % 10;
            result.next = new ListNode(curr);

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            result = result.next;
        }

        if (plus > 0) {
            result.next = new ListNode(plus);
        }

        //注意：result.next返回为空
        return head.next;
    }
}
