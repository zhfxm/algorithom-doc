/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.gui.sort.quick;

import com.zh.algorithm.gui.util.AlgoVisHelper;

import javax.swing.*;
import java.awt.*;

/**
 * hui.zhang QuickFrame
 *
 * @author hui.zhang
 * @since 2019-01-18 16:56
 */
public class QuickFrame extends JFrame {

    private int canvasWidth;

    private int canvasHeight;

    public QuickFrame(int canvasHeight, int canvasWidth, String title) {
        super(title);
        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;
        QuickPanel panel = new QuickPanel();
        //设置面板
        this.setContentPane(panel);
        this.pack();
        //进制修改窗口大小
        this.setResizable(false);
        //关闭窗口时停止程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //显示窗口
        this.setVisible(true);
    }

    private QuickSortData data;

    public void render(QuickSortData data) {
        this.data = data;
        this.repaint();
    }

    public class QuickPanel extends JPanel {

        public QuickPanel() {super(true);}

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);
            AlgoVisHelper.setColor(g2d, AlgoVisHelper.Grey);
            double w = (double) canvasWidth / data.getSize();
            for (int i = 0; i < data.getSize(); i++) {
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