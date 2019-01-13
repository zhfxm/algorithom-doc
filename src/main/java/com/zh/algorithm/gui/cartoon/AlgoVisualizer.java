/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.gui.cartoon;

import com.zh.algorithm.gui.AlgoFrame;
import com.zh.algorithm.gui.util.AlgoVisHelper;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * hui.zhang AlgoVisualizer
 *
 * @author hui.zhang
 * @since 2019-01-11 11:12
 */
public class AlgoVisualizer {

    private Circle[] circles;

    private AlgoFrame algoFrame;

    private boolean isAnimated = true;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int n) {
        int r = 50;
        circles = new Circle[n];
        for (int i = 0; i < 10; i++) {
            int x = (int) (Math.random() * (sceneWidth - 2 * r)) + r;
            int y = (int) (Math.random() * (sceneHeight - 2 * r)) + r;
            int vx = (int) (Math.random() * 11) - 5;
            int vy = (int) (Math.random() * 11) - 5;
            circles[i] = new Circle(x, y, r, vx, vy);
        }
        EventQueue.invokeLater(() -> {
            algoFrame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            //添加键盘监听事件
            algoFrame.addKeyListener(new AlgoKeyListener());
            //添加鼠标监听时间
            algoFrame.addMouseListener(new AlgoMouseListener());
            new Thread(this::run).start();

        });
    }

    private void run(){
        while (true) {
            //绘制数据
            algoFrame.render(circles);
            AlgoVisHelper.pause(20);
            //更新数据
            if (isAnimated) {
                for (Circle circle : circles) {
                    circle.move(0, 0, algoFrame.getCanvasWidth(), algoFrame.getCanvasHeight());
                }
            }
        }
    }

    /**
     * 键盘事件
     */
    private class AlgoKeyListener extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyChar() == ' ') {
                isAnimated = !isAnimated;
            }
        }

    }

    private class AlgoMouseListener extends MouseAdapter {

        /**
         * 按下鼠标左键事件
         * @param e
         */
        @Override
        public void mousePressed(MouseEvent e) {
            //设置坐标点只在画布中，去掉菜单栏的纵坐标差异
            //鼠标点击点坐标转换
            e.translatePoint(0, algoFrame.getBounds().height - algoFrame.getCanvasHeight());
            for (Circle circle : circles) {
                if (circle.contain(e.getPoint())) {
                    circle.isFilled = !circle.isFilled;
                }
            }
        }
    }

    public static void main(String[] args) {
        new AlgoVisualizer(800, 800, 20);
    }
}