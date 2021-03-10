package com.pl.algorithm.based.sort;

import com.pl.algorithm.utils.LogarithmicDetectorUtil;
import com.pl.algorithm.utils.MyArrayUtil;

/**
 * @author LIPIAO
 * @date 2021/3/10 15:13
 * <p>
 * 算法 - 冒泡排序
 * <p>
 * ~~~~~~~~~~~~~~~~~~~~~~左神分析
 * 过程：
 * 在arr[0～N-1]范围上：arr[0]和arr[1]，谁大谁来到1位置；arr[1]和arr[2]，谁大谁来到2位置…arr[N-2]和arr[N-1]，谁大谁来到N-1位置
 * <p>
 * 在arr[0～N-2]范围上，重复上面的过程，但最后一步是arr[N-3]和arr[N-2]，谁大谁来到N-2位置
 * 在arr[0～N-3]范围上，重复上面的过程，但最后一步是arr[N-4]和arr[N-3]，谁大谁来到N-3位置
 * …
 * 最后在arr[0～1]范围上，重复上面的过程，但最后一步是arr[0]和arr[1]，谁大谁来到1位置
 * <p>
 * 估算：
 * 很明显，如果arr长度为N，每一步常数操作的数量，依然如等差数列一般
 * 所以，总的常数操作数量 = a*(N^2) + b*N + c (a、b、c都是常数)
 * <p>
 * 所以冒泡排序的时间复杂度为O(N^2)。
 */
public class BubbleSort {

    public static void main(String[] args) {
        LogarithmicDetectorUtil.bubbleSortTest(1_000_000, 10000, 1_000_000);
    }

    /**
     * 冒泡排序实现一次
     *
     * @param array 需要排序的数组
     */
    public static void bubbleSort01(int[] array) {

        if (null == array || array.length < 2) {
            return;
        }

        for (int i = array.length - 1; i > 0; i--) {
            // 每次在[0 ~ i-1]范围内去找
            for (int j = 0; j < i; j++) {
                //如果当前位置的值比后一个位置的值大，那么交换这两个位置的值，把当前位置的值换到后边的位置，把后面位置的值换到当前位置
                if (array[j] > array[j + 1]) {
                    MyArrayUtil.swapValByBitOperation(array, j, j + 1);
                }
            }
        }

    }

}
