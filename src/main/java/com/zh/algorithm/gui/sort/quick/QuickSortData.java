/*
 * Copyright (c) 2016, BITMAIN and/or its affiliates. All rights reserved.
 * BITMAIN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zh.algorithm.gui.sort.quick;

import com.zh.algorithm.gui.util.AlgoVisHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * hui.zhang QuickSortData
 *
 * @author hui.zhang
 * @since 2019-01-18 17:05
 */
public class QuickSortData {

    public int[] numbers;

    public int orderIndex;

    public int currentIndex;

    public int currentCompareIndex;

    /**
     * 构造
     * @param n 数组长度
     * @param bound 最大值
     */
    public QuickSortData(int n, int bound){
        Random r = new Random();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = r.nextInt(bound);
        }
    }

    public int get(int i) {
        if (i >= numbers.length) {
            throw new IllegalArgumentException("数组越界");
        }
        return numbers[i];
    }

    public int getSize(){
        return numbers.length;
    }

    public void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public void quickSort(int[] a, int low, int high){
        if(low > high){
            return;
        }
        int i = low, j = high, key = a[low];

        while(i < j){
//从右往左遍历 找到第一个比标准值小的值
            while(i < j && key < a[j]){
                j--;
            }
//从左往右遍历 找到第一个比标准值大的值
            while(i < j && key >= a[i]){
                i++;
            }
//找到之后两者调换位置
            if(i < j){
                int mid = a[i];
                a[i] = a[j];
                a[j] = mid;
            }
        }
//i == j  调换标尺值的位置
        a[low] = a[i];
        a[i] = key;
//遍历标尺值左边的数组
        quickSort(a, low, i - 1);
//遍历标尺值右边的数组
        quickSort(a, i + 1, high);
    }

    private void quickSort(QuickSortData data, int start, int end) {
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
        }
        if (i == j) {
            data.swap(i, start);
        }
        quickSort(data, start, i - 1);
        quickSort(data, i + 1, end);
    }

    public static void main(String[] args) {
        QuickSortData data = new QuickSortData(10, 800);
//        data.quickSort(data.numbers, 0, data.getSize() - 1);
        data.quickSort(data, 0, data.getSize()-1);
        System.out.println(Arrays.toString(data.numbers));
    }
}