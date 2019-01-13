/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.gui;

import com.zh.algorithm.gui.cartoon.AlgoVisualizer;

/**
 * hui.zhang AlgoTest
 *
 * @author hui.zhang
 * @since 2019-01-10 20:25
 */
public class AlgoTest {

    public static void main(String[] args) {
        int sceneWidth = 800;
        int sceneHeight = 800;

        int n = 10;
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, n);
    }
}