/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.gui.sort.insert;

import com.zh.algorithm.gui.util.AlgoVisHelper;

import java.awt.*;

/**
 * hui.zhang InsertVisualizer
 *
 * @author hui.zhang
 * @since 2019-01-17 20:10
 */
public class InsertVisualizer {

    private InsertSortData data;

    private InsertFarme farme;

    private static final int DELAY = 10;

    public InsertVisualizer(int canvasWidth, int canvasHeight, int n) {
        data = new InsertSortData(n, canvasHeight);
        EventQueue.invokeLater(() -> {
            farme = new InsertFarme("插入排序", canvasWidth, canvasHeight);
            new Thread(this::run).start();
        });
    }

    private void run() {
        this.setData(0, -1);
        for (int i = 1; i < data.getSize(); i++) {
            for (int j = i; j > 0 && data.get(j - 1) > data.get(j); j--) {
                data.swap(j - 1, j);
                this.setData(i, j - 1);
            }
            this.setData(i, -1);
        }
        this.setData(data.getSize(), -1);
    }

    private void setData(int orderIndex, int currentCompareIndex) {
        data.orderIndex = orderIndex;
        data.currentCompareIndex = currentCompareIndex;
        farme.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        new InsertVisualizer(800, 800, 100);
    }
}