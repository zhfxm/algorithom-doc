/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.gui.sort.quick;

import com.zh.algorithm.gui.util.AlgoVisHelper;

import java.awt.*;
import java.util.Arrays;

/**
 * hui.zhang QuickVisualizer
 *
 * @author hui.zhang
 * @since 2019-01-18 17:14
 */
public class QuickVisualizer {
    private QuickSortData data;

    private QuickFrame frame;

    private static final int DELAY = 10;

    public QuickVisualizer(int n, int canvasWidth, int canvasHeight) {
        data = new QuickSortData(n, canvasHeight);
        EventQueue.invokeLater(() ->{
            frame = new QuickFrame(canvasHeight, canvasWidth, "快排");
            new Thread(this::run).start();
        });
    }

    private void run(){
        quickSort(data, 0, data.getSize() - 1);
    }

    private void quickSort(QuickSortData data, int start, int end) {
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
        if (start >= end) {
            return;
        }
        int i = start, j = end, k = data.get(start);
        while (i < j) {
            while (i < j && data.get(j) > k) {
                j--;
            }
            while (i < j && data.get(i) <= k) {
                i++;
            }
            if (i < j) {
                data.swap(i, j);
            }
            frame.render(data);
            AlgoVisHelper.pause(DELAY);
        }
        if (i == j) {
            data.swap(i, start);
        }
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
        quickSort(data, start, i - 1);
        quickSort(data, i + 1, end);
    }

    private void setData(int currentIndex, int currentCompareIndex) {
        data.currentCompareIndex = currentCompareIndex;
        data.currentIndex = currentIndex;
        this.frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        new QuickVisualizer(1000, 800, 800);
    }
}