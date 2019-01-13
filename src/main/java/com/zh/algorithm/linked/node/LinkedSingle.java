/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.linked.node;

import lombok.Data;

/**
 * hui.zhang LinkedSingle
 *
 * @author hui.zhang
 * @since 2019-01-03 10:08
 */
@Data
public class LinkedSingle {

    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * 链表容量
     */
    private int capacity;

    private int size;

    /**
     * 头节点
     */
    private Node head;

    /**
     * 尾节点
     */
    private Node detail;

    public LinkedSingle() {
        this.capacity = DEFAULT_INITIAL_CAPACITY;
    }

    public LinkedSingle(int capacity) {
        this.capacity = capacity;
    }

    @Data
    static class Node{
        private int data;
        private Node next;

        public Node() {
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public void push(int data){
        if (size >= capacity) {
            throw new RuntimeException("链表已满");
        }
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node n = detail;
            n.setNext(node);
        }
        size++;
        detail = node;
    }

    public int popHead() {
        if (head == null) {
            throw new RuntimeException("链表为空");
        }
        int num = head.data;
        head = head.next;
        size--;
        return num;
    }

    public int popDetail() {
        if (head == null) {
            throw new RuntimeException("链表为空");
        }
        if (head == detail) {
            return popHead();
        }
        Node node = head;
        while (node.next != detail) {
            node = head.next;
        }
        node.next = null;
        int num = detail.data;
        detail = node;
        size--;
        return num;
    }

    public int delete(int d) {
        if (head == null) {
            throw new RuntimeException("链表为空");
        }
        if (head.data == d){
            return this.popHead();
        }
        Node node = head;
        while (null != node.next && node.next.data != d) {
            node = node.next;
        }
        if (node.next == null) {
            throw new RuntimeException("数据不存在");
        }
        if (node.next == detail) {
            return this.popDetail();
        }
        node.next = node.next.next;
        size--;
        return d;
    }

    public static void main(String[] args) {
        LinkedSingle linked = new LinkedSingle();
        linked.push(1);
        linked.push(3);
        linked.push(5);
        linked.delete(3);
        System.out.println(linked.detail);
        Node node = linked.getHead();
        for (int i = 0; i < linked.getSize(); i++) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }
}