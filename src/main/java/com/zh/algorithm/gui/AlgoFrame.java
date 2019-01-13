/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.gui;

import com.zh.algorithm.gui.cartoon.Circle;
import com.zh.algorithm.gui.util.AlgoVisHelper;

import javax.swing.*;
import java.awt.*;

/**
 * hui.zhang AlgoFrame
 *
 * @author hui.zhang
 * @since 2019-01-10 19:59
 */
public class AlgoFrame extends JFrame {

    private int canvasWidth;

    private int canvasHeight;

    public AlgoFrame(String title) {
        this(title, 700, 700);
    }

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);
        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;

        //初始化画布
        AlgoCanvas canvas = new AlgoCanvas();
        //设置画布的大小 若复写JPanel中的getPreferredSize方法可不用显示的设置画布大小
//        canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        //设置内容面板
        setContentPane(canvas);
        //使窗口大小适用画布大小
        pack();
//        setSize(canvasWidth, canvasHeight); //jframe设置窗口大小
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

    private Circle[] circles;

    public void render(Circle[] circles) {
        this.circles = circles;
        repaint();
    }

    /**
     * jpanel支持双缓存
     */
    private class AlgoCanvas extends JPanel {

        public AlgoCanvas() {
            super(true);
        }

        /**
         * 重新绘制组件
         * @param g
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //自定义的绘制

            //绘制园 Graphics (比较原始的类)
//            g.drawOval(50, 50, 300, 300);

            //使用Graphics2D 来绘制圆
            Graphics2D g2d = (Graphics2D) g;
            //抗锯齿 VALUE_ANTIALIAS_ON:打开抗锯齿
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);

            //设置笔画的宽度
            AlgoVisHelper.setStrokeWidth(g2d, 1);
            //绘制实心圆
//            AlgoVisHelper.setColor(g2d, Color.blue);
//            AlgoVisHelper.fillCircle(g2d, canvasWidth/2, canvasHeight/2, 300);

            //设置画笔颜色
            AlgoVisHelper.setColor(g2d, Color.RED);
            //绘制空心圆
//            AlgoVisHelper.strokeCircle(g2d, canvasWidth/2, canvasHeight/2, 300);
            for (Circle circle : circles) {
                if (!circle.isFilled) {
                    AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
                } else {
                    AlgoVisHelper.fillCircle(g2d, circle.x, circle.y, circle.getR());
                }
            }
        }

        /**
         * 返回画布的大小 初始化时会自动调用该方法设置画布的大小即可不用显示的调用设置画布的大小
         */
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}