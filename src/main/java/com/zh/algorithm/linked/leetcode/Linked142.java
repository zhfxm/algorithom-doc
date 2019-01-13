/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.linked.leetcode;

/**
 * hui.zhang Linked142
 *
 * @author hui.zhang
 * @since 2019-01-09 19:08
 */

import com.google.common.hash.BloomFilter;

/**
 * 环形链表，并返回入环节点
 */
public class Linked142 {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Linked142 linked = new Linked142();
        linked.detectCycle(ListNode.palindrome());
    }
}