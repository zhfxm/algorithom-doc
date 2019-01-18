/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.gui.sort.insert;

import com.zh.algorithm.gui.util.AlgoVisHelper;

import javax.swing.*;
import java.awt.*;

/**
 * hui.zhang InsertFarme
 *
 * @author hui.zhang
 * @since 2019-01-17 16:46
 */
public class InsertFarme extends JFrame {

    private int canvasWidth;

    private int canvasHeight;


    public InsertFarme(String title, int canvasWidth, int canvasHeight) {
        super(title);
        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;
        InsertPanel panel = new InsertPanel();
        this.setContentPane(panel);
        //使窗口大小适合画布大小
        this.pack();
        //设置是否可以改变窗口大小 false:不  true:可
        this.setResizable(false);
         //设置默认关闭操作
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private InsertSortData data;

    public void render(InsertSortData data) {
        this.data = data;
        this.repaint();
    }

    public class InsertPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            //抗锯齿
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);
            //设置画笔宽度
            AlgoVisHelper.setStrokeWidth(g2d, 1);
            AlgoVisHelper.setColor(g2d, AlgoVisHelper.Grey);
            double w = (double) canvasWidth / data.getSize();
            for (int i = 0; i < data.getSize(); i++) {
                if (i <= data.orderIndex) {
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Red);
                } else {
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Grey);
                }
                if (data.currentCompareIndex == i) {
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.LightBlue);
                }
                AlgoVisHelper.fillRectangle(g2d, i * w, canvasHeight - data.get(i),
                        w - 0.1, data.get(i));
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(canvasWidth, canvasHeight);
    }
}