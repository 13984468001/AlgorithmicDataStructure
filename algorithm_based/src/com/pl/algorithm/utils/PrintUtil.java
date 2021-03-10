package com.pl.algorithm.utils;

/**
 * @author LIPIAO
 * @date 2021/3/10 11:48
 * <p>
 * 打印工具类
 */
public class PrintUtil<T> {

    /**
     * 控制台输出一个数组
     *
     * @param arr
     */
    public void printArr(T[] arr) {

        if (null == arr || arr.length == 0) {
            return;
        }

        for (T val : arr) {
            System.out.print(val.toString() + "; ");
        }
        System.out.println();

    }

}
