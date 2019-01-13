/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.linked.leetcode;

/**
 * hui.zhang ListNode
 *
 * @author hui.zhang
 * @since 2019-01-08 19:20
 */
public class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode palindrome() {
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node.next = node1;
        node1.next = node3;
        node3.next = node4;
        node4.next = node1;
        return node;
    }
}