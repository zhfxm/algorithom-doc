/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.gui.sort.insert;

import java.util.Random;

/**
 * hui.zhang InsertSortData
 *
 * @author hui.zhang
 * @since 2019-01-17 16:57
 */
public class InsertSortData {

    private int[] numbers;

    /**
     * [0...orderIndex] 表示有序的列表
     */
    public int orderIndex = -1;

    /**
     * 当前最小值下标
     */
//    public int currentMinIndex = -1;

    /**
     * 当前正在比较的值的下标
     */
    public int currentCompareIndex = -1;

    public InsertSortData(int total, int bound) {
        numbers = new int[total];
        Random r = new Random();
        for (int i = 0; i < total; i++) {
            numbers[i] = r.nextInt(bound);
        }
    }

    /**
     * 获取数组长度
     * @return
     */
    public int getSize() {
        return numbers.length;
    }

    /**
     * 获取数据
     * @param i
     * @return
     */
    public int get(int i) {
        if (i >= numbers.length) {
            throw new IllegalArgumentException("数据越界");
        }
        return numbers[i];
    }

    /**
     * 数据交换
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        InsertSortData data = new InsertSortData(10, 10);
        for (int i = 0; i < 10; i++) {
            System.out.println(data.numbers[i]);
        }
    }
}