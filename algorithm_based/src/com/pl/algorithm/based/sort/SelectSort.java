package com.pl.algorithm.based.sort;

import com.pl.algorithm.utils.LogarithmicDetectorUtil;
import com.pl.algorithm.utils.MyArrayUtil;

/**
 * @author LIPIAO
 * @date 2021/3/10 11:10
 * <p>
 * 算法-选择排序
 * <p>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~ 左神分析
 * <p>
 * 过程：
 * arr[0～N-1]范围上，找到最小值所在的位置，然后把最小值交换到0位置。
 * arr[1～N-1]范围上，找到最小值所在的位置，然后把最小值交换到1位置。
 * arr[2～N-1]范围上，找到最小值所在的位置，然后把最小值交换到2位置。
 * …
 * arr[N-1～N-1]范围上，找到最小值位置，然后把最小值交换到N-1位置。
 * <p>
 * 估算：
 * 很明显，如果arr长度为N，每一步常数操作的数量，如等差数列一般
 * 所以，总的常数操作数量 = a*(N^2) + b*N + c (a、b、c都是常数)
 * <p>
 * 所以选择排序的时间复杂度为O(N^2)。
 */
public class SelectSort {

    public static void main(String[] args) {
        // 100W个随机样本，每个样本最大长度100，样本中元素最大值100
        LogarithmicDetectorUtil.selectSortTest(1_000_000, 100, 100);
    }

    /**
     * 实现一次
     */
    public static void selectSort01(int[] arr) {

        if (null == arr || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            //第一层循环规定好最小值所在的范围i+1 ~ N-1
            for (int j = i + 1; j < arr.length; j++) {
                //第二层循环在指定范围i+1 ~ N-1内找到最小值并放到i位置
                if (arr[i] > arr[j]) {
                    //假设i+1位置也就是j位置上的值最小
                    //如若i位置的值比i+1位置的值大，则把i位置的值换到i+1位置，i+1位置的值换到i位置。这里的位置指的是数组下标
                    //MyArrayUtil.swapValByBitOperation(arr, i, j);
                    MyArrayUtil.swapValByTripartite(arr, i, j);
                }
            }
        }
    }


}
