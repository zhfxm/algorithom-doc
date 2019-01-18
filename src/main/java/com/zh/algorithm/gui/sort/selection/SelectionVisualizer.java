/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.gui.sort.selection;

import com.zh.algorithm.gui.util.AlgoVisHelper;

import java.awt.*;

/**
 * hui.zhang SelectionVisualizer
 *
 * @author hui.zhang
 * @since 2019-01-11 17:36
 */
public class SelectionVisualizer {

    private SelectionSortData data;

    private SelectionFrame frame;

    public static final int DELAY = 100;

    /**
     *
     * @param sceneWidth 画布宽
     * @param sceneHeight 画布高
     * @param n 数据规模大小
     */
    public SelectionVisualizer(int sceneWidth, int sceneHeight, int n) {
        //数据初始化
        data = new SelectionSortData(n, sceneHeight);

        EventQueue.invokeLater(() ->{
            frame = new SelectionFrame("选择排序", sceneWidth, sceneHeight);
            new Thread(this::run).start();
        });
    }

    public void run() {
        this.setData(0, -1, -1);
        for (int i = 0; i < data.getN(); i++) {
            int minIndex = i;
            this.setData(i, -1, minIndex);
            for (int j = i + 1; j < data.getN(); j++) {
                this.setData(i, j, minIndex);
                if (data.get(j) < data.get(minIndex)){
                    minIndex = j;
                    this.setData(i, j, minIndex);
                }
            }
            data.swap(i, minIndex);
            this.setData(i + 1, -1, -1);
        }
        this.setData(data.getN(), -1, -1);
    }

    private void setData(int orderIndex, int currentMinIndex, int currentCompareIndex) {
        data.orderIndex = orderIndex;
        data.currentCompareIndex = currentCompareIndex;
        data.currentMinIndex = currentMinIndex;
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        int sceneWidth = 800;
        int sceneHeight = 800;
        int n = 100;
        new SelectionVisualizer(sceneWidth, sceneHeight, n);
    }
}