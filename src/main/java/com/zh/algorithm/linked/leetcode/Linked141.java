/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.linked.leetcode;

/**
 * hui.zhang Linked141
 *
 * @author hui.zhang
 * @since 2019-01-09 16:20
 */

/**
 * 判断链表是否有环
 */
public class Linked141 {

    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode fast = new ListNode(0);
        ListNode slow = new ListNode(0);
        fast.next = head;
        slow.next = head;
        while (true) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
    }
}