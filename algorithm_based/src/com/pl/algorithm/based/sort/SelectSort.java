package com.pl.algorithm.based.sort;

import com.pl.algorithm.utils.PrintUtil;

import java.util.Arrays;

/**
 * @author LIPIAO
 * @date 2021/3/10 11:10
 * <p>
 * 算法-选择排序
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
        //打印工具
        PrintUtil<Integer> printUtil = new PrintUtil<>();

        //先来一个数组
        Integer[] arr = {10, 11, 22, 31, 456, 345, 89, 34, 121, 135};

        selectSort01(arr);
        System.out.println("手撕选择排序，实现一次：");
        printUtil.printArr(arr);

        Arrays.sort(arr);
        System.out.println("\njava库排序：");
        printUtil.printArr(arr);

        //写一个对数器测试算法可用性
    }

    /**
     * 实现一次
     */
    private static void selectSort01(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //第一层循环规定好最小值所在的范围i+1 ~ N-1
            for (int j = i + 1; j < arr.length; j++) {
                //第二层循环在指定范围i+1 ~ N-1内找到最小值并放到i位置
                if (arr[i] > arr[j]) {
                    //如若i位置的值比i+位置的值大，则把i位置的值换到i+1位置，i+1位置的值换到i位置
                    //swapValByBitOperation(arr, i, j);
                    swapValByTripartite(arr, i, j);
                }
            }
        }
    }

    /**
     * 位运算方式交换值
     *
     * @param arr 操作的数组
     * @param i   操作的索引位置一
     * @param j   操作的索引位置二
     */
    private static void swapValByBitOperation(Integer[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 借助三方变量方式交换值
     *
     * @param arr 操作的数组
     * @param i   操作的索引位置一
     * @param j   操作的索引位置二
     */
    private static void swapValByTripartite(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
