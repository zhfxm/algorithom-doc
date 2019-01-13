/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.linked.leetcode;

/**
 * hui.zhang Linked237
 *
 * @author hui.zhang
 * @since 2019-01-10 14:17
 */

/**
 * 删除节点，只给出要删除的节点，该节点是链表中的一部分。
 * 解题思路：把要删除的节点的后继节点的值复制到需要删除的节点中，再把删除节点的后继节点删除
 */
public class Linked237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}