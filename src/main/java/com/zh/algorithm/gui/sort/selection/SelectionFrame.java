/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.gui.sort.selection;

import com.zh.algorithm.gui.util.AlgoVisHelper;

import javax.swing.*;
import java.awt.*;

/**
 * hui.zhang SelectionFrame
 *
 * @author hui.zhang
 * @since 2019-01-11 17:21
 */
public class SelectionFrame extends JFrame {
    private int canvasWidth;

    private int canvasHeight;

    public SelectionFrame(String title) {
        this(title, 800, 800);
    }

    public SelectionFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);
        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;
        //初始化画布
        SelectionCanvas canvas = new SelectionCanvas();
        //设置面板内容
        setContentPane(canvas);
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    private SelectionSortData selectionData;

    public void render(SelectionSortData selectionData) {
        this.selectionData = selectionData;
        repaint();
    }

    private class SelectionCanvas extends JPanel {
        public SelectionCanvas() {
            super(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            //抗锯齿
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            //设置画笔宽度
            AlgoVisHelper.setStrokeWidth(g2d, 1);

            //TODO 具体绘制  data数据
            double w = (double) canvasWidth/selectionData.getN();
            AlgoVisHelper.setColor(g2d, AlgoVisHelper.LightBlue);
            for (int i = 0; i < selectionData.getN(); i++) {
                AlgoVisHelper.fillRectangle(g2d, (double) i * w, canvasHeight - selectionData.get(i),
                        (double) w - 0.1, selectionData.get(i));
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}