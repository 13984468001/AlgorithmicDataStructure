package com.pl.algorithm.utils;

import java.util.Arrays;

/**
 * @author LIPIAO
 * @date 2021/3/10 13:37
 * <p>
 * 产生随机数据的工具
 */
public class GenerateRandomDataUtil {

    /**
     * 产生一个整形数组
     *
     * @param maxSize 数组最大长度
     * @param maxVal  元素最大值
     * @return int类型数组
     */
    public static int[] generateRandomIntArray(int maxSize, int maxVal) {
        if (maxSize <= 0 || maxVal <= 0) {
            return new int[0];
        }
        //创建一个任意长度小于等于maxSize的整型数组
        int[] array = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < array.length; i++) {
            //产生任意一个整数
            array[i] = (int) ((maxVal + 1) * Math.random()) - (int) ((maxSize + 1) * Math.random());
        }

        return array;
    }




}
