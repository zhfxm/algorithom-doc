/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.linked.leetcode;

/**
 * hui.zhang Linked234
 *
 * @author hui.zhang
 * @since 2019-01-08 19:20
 */

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class Linked234 {

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode first = new ListNode(0);
        ListNode second = new ListNode(0);
        first.next = head;
        second.next = head;
        while (second.next != null) {
            first = first.next;
            ListNode mid = second.next.next;
            if (mid == null) {
                second = second.next;
            } else {
                second = mid;
            }
        }
        ListNode headNode = null, prec = null;
        ListNode current = first.next;
        while (current != null) {
            ListNode nextNode = current.next;
            if (nextNode == null) {
                headNode = current;
            }
            current.next = prec;
            prec = current;
            current = nextNode;
        }
        while (headNode != null) {
            if (headNode.val == head.val) {
                headNode = headNode.next;
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isPalindrome(ListNode.palindrome());
    }
}