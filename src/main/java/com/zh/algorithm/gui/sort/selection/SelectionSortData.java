/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.gui.sort.selection;

/**
 * hui.zhang SelectionSortData
 *
 * @author hui.zhang
 * @since 2019-01-11 15:35
 */

/**
 * 选择排序
 */
public class SelectionSortData {

    private int[] numbers;

    public SelectionSortData(int n, int bound) {
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = (int) (Math.random() * bound) + 1;
        }
    }

    public int getN(){
        return numbers.length;
    }

    public int get(int index) {
        if (index < 0 || index >= numbers.length) {
            throw new IllegalArgumentException("数组下标溢出");
        }
        return numbers[index];
    }

    /**
     * 数据交换
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}