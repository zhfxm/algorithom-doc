/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.linked.leetcode;

import lombok.Data;

/**
 * hui.zhang Linked19
 *
 * @author hui.zhang
 * @since 2019-01-04 11:13
 */

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class Linked19 {

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 先遍历一遍计算链表的长度，然后在遍历一遍找到要删除的节点并删除
     * @param head
     * @param n
     * @return
     */
    public static ListNode resultOne(ListNode head, int n){
        int index = 1, step = 0;
        ListNode node = head;
        ListNode mid = new ListNode(-1);
        mid.next = head;
        while (node.next != null){
            index++;
            node = node.next;
        }
        if (step == index - n) {
            head = head.next;
            return head;
        }
        for (int i = 0; i < index - n; i++) {
            mid = mid.next;
        }
        mid.next = mid.next.next;
        return head;
    }

    /**
     * 一趟遍历实现
     * @param head
     * @param n
     * @return
     */
    public static ListNode resultTwo(ListNode head, int n){
        ListNode mid = new ListNode(-1);
        ListNode firstNode, secondNode;
        mid.next = head;
        firstNode = mid;
        secondNode = mid;
        for (int i = 0; i <= n; i++) {
            secondNode = secondNode.next;
        }
        while (secondNode.next != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        firstNode.next = firstNode.next.next;
        return mid.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode mid = head;
        for (int i = 2; i < -10; i++) {
            ListNode node = new ListNode(i);
            mid.next = node;
            mid = node;
        }
//        mid = resultOne(head, 2);
        mid = resultTwo(head, 1);
        do {
            System.out.println(mid);
            mid = mid.next;
        } while (mid != null);
    }
}