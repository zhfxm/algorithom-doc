/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.gui;

import javax.swing.*;
import java.awt.*;

/**
 * hui.zhang TestGur
 *
 * @author hui.zhang
 * @since 2019-01-10 19:43
 */
public class TestGur {
    public static void main(String[] args) {
        //时间分发事件队列
        EventQueue.invokeLater(() -> {
            JFrame jFrame = new JFrame("welcome");
            //设置窗口的宽高
            jFrame.setSize(500, 500);
            //是否允许用户重新定义窗口大小
            jFrame.setResizable(false);
            //设置窗口关闭之后的操作 3:关闭时退出
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //设置窗口的显示
            jFrame.setVisible(true);
        });
    }
}