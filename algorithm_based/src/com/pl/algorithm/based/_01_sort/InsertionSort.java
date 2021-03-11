package com.pl.algorithm.based._01_sort;

import com.pl.algorithm.utils.MyArrayUtil;

/**
 * @author LIPIAO
 * @date 2021/3/10 16:04
 * <p>
 * 算法 - 插入排序
 * <p>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~左神分析
 * <p>
 * 过程：
 * 想让arr[0~0]上有序，这个范围只有一个数，当然是有序的。
 * 想让arr[0~1]上有序，所以从arr[1]开始往前看，如果arr[1]<arr[0]，就交换。否则什么也不做。
 * …
 * 想让arr[0~i]上有序，所以从arr[i]开始往前看，arr[i]这个数不停向左移动，一直移动到左边的数字不再比自己大，停止移动。
 * 最后一步，想让arr[0~N-1]上有序， arr[N-1]这个数不停向左移动，一直移动到左边的数字不再比自己大，停止移动。
 * <p>
 * 估算时发现这个算法流程的复杂程度，会因为数据状况的不同而不同。
 * <p>
 * 你发现了吗？
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * 如果某个算法流程的复杂程度会根据数据状况的不同而不同，那么你必须要按照最差情况来估计。
 * <p>
 * 很明显，在最差情况下，如果arr长度为N，插入排序的每一步常数操作的数量，还是如等差数列一般
 * <p>
 * 所以，总的常数操作数量 = a*(N^2) + b*N + c (a、b、c都是常数)
 * <p>
 * 所以插入排序排序的时间复杂度为O(N^2)。
 */
public class InsertionSort {

    public static void main(String[] args) {
        LogarithmicDetectorUtil.insertionSortTest(1_000_000, 100, 100);
    }

    /**
     * 插入排序算法那实现一次
     *
     * @param array 需要排序的数组
     */
    public static void insertionSort01(int[] array) {

        if (null == array || array.length < 2) {
            return;
        }

        // 0 ~ 0 只有一个元素，本身有序
        // 0 ~ i 想要变得有序
        for (int i = 1; i < array.length; i++) {
            // array[i]往前看，也就是array[j+i]往前看，如果前一个位置比自己大，则把自己当前位置的值换到前一个位置，前一个位置的值换到当前位置，直到前一个位置的值不比自己大为止
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                MyArrayUtil.swapValByBitOperation(array, j, j + 1);
            }
        }
    }

}
