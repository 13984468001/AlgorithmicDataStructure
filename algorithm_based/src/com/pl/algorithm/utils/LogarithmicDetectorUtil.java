package com.pl.algorithm.utils;

import com.pl.algorithm.based.sort.BubbleSort;
import com.pl.algorithm.based.sort.InsertionSort;
import com.pl.algorithm.based.sort.SelectSort;

/**
 * @author LIPIAO
 * @date 2021/3/10 14:49
 * <p>
 * 对数器工具
 * <p>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~左神分析
 * <p>
 * 我们会发现，时间复杂度这个指标，是忽略低阶项和所有常数系数的。
 * <p>
 * 难道同样时间复杂度的流程，在实际运行时候就一样的好吗？
 * <p>
 * 当然不是。
 * <p>
 * 时间复杂度只是一个很重要的指标而已。如果两个时间复杂度一样的算法，你还要去在时间上拼优劣，就进入到拼常数时间的阶段，简称拼常数项。
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 算法流程的常数项的比拼方式
 * <p>
 * 放弃理论分析，生成随机数据直接测。
 * <p>
 * 为什么不去理论分析？
 * <p>
 * 不是不能纯分析，而是没必要。因为不同常数时间的操作，虽然都是固定时间，但还是有快慢之分的。
 * <p>
 * 比如，位运算的常数时间原小于算术运算的常数时间，这两个运算的常数时间又远小于数组寻址的时间。
 * <p>
 * 所以如果纯理论分析，往往会需要非常多的分析过程。都已经到了具体细节的程度，莫不如交给实验数据好了。
 */
public class LogarithmicDetectorUtil {

    /**
     * 检验选择排序算法可用性
     *
     * @param sampleNum
     * @param maxSize
     * @param maxValue
     * @return 返回算法可用性结果
     */
    public static boolean selectSortTest(int sampleNum, int maxSize, int maxValue) {
        boolean result = true;
        for (int i = 0; i < sampleNum; i++) {
            int[] array01 = GenerateRandomDataUtil.generateRandomIntArray(maxSize, maxValue);
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
        printAlgorithmUsableResult(result);
        return result;
    }

    /**
     * 检验冒泡排序算法可用性
     *
     * @param sampleNum
     * @param maxSize
     * @param maxValue
     * @return 返回算法可用性结果
     */
    public static boolean bubbleSortTest(int sampleNum, int maxSize, int maxValue) {
        boolean result = true;
        for (int i = 0; i < sampleNum; i++) {
            int[] array01 = GenerateRandomDataUtil.generateRandomIntArray(maxSize, maxValue);
            int[] array02 = MyArrayUtil.copyIntArray(array01);
            BubbleSort.bubbleSort01(array01);
            MyArrayUtil.comparatorIntArray(array02);
            if (!MyArrayUtil.isTwoIntArrayEqual(array01, array02)) {
                result = false;
                PrintUtil.printIntArr(array01);
                PrintUtil.printIntArr(array02);
                break;
            }
        }
        printAlgorithmUsableResult(result);
        return result;
    }

    /**
     * 检验插入排序算法可用性
     *
     * @param sampleNum
     * @param maxSize
     * @param maxValue
     * @return 返回算法可用性结果
     */
    public static boolean insertionSortTest(int sampleNum, int maxSize, int maxValue) {
        boolean result = true;
        for (int i = 0; i < sampleNum; i++) {
            int[] array01 = GenerateRandomDataUtil.generateRandomIntArray(maxSize, maxValue);
            int[] array02 = MyArrayUtil.copyIntArray(array01);
            InsertionSort.insertionSort01(array01);
            MyArrayUtil.comparatorIntArray(array02);
            if (!MyArrayUtil.isTwoIntArrayEqual(array01, array02)) {
                result = false;
                PrintUtil.printIntArr(array01);
                PrintUtil.printIntArr(array02);
                break;
            }
        }
        printAlgorithmUsableResult(result);
        return result;
    }

    /**
     * 打印算法可用性结果
     *
     * @param result
     */
    public static void printAlgorithmUsableResult(boolean result) {
        if (result) {
            System.out.println("算法可用！");
        } else {
            System.out.println("算法不可用！");
        }
    }

}
