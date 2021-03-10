package com.pl.algorithm.utils;

import com.pl.algorithm.based.sort.SelectSort;

/**
 * @author LIPIAO
 * @date 2021/3/10 14:49
 * <p>
 * 对数器工具
 * <p>
 * 检验算法可用性
 */
public class LogarithmicDetectorUtil {

    public static boolean selectSortTest(int sampleNum, int maxSize, int maxValue) {
        boolean result = true;
        for (int i = 0; i < sampleNum; i++) {
            int[] array01 = GenerateRandomDataUtil.generateRandomIntArray(maxSize, maxSize);
            int[] array02 = MyArrayUtil.copyIntArray(array01);
            SelectSort.selectSort01(array01);
            MyArrayUtil.comparatorIntArray(array02);
            if (!MyArrayUtil.isTwoIntArrayEqual(array01, array02)) {
                result = false;
                PrintUtil.printIntArr(array01);
                PrintUtil.printIntArr(array02);
                break;
            }
        }
        return result;
    }

}
