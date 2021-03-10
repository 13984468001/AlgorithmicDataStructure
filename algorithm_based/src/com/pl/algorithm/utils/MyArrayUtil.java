package com.pl.algorithm.utils;

import java.util.Arrays;

/**
 * @author LIPIAO
 * @date 2021/3/10 15:00
 * <p>
 * 数组操作工具
 */
public class MyArrayUtil {

    /**
     * 根据跟定数组拷贝出一个同样的新数组
     *
     * @param array 需要拷贝的数组
     * @return 拷贝出来的新数组
     */
    public static int[] copyIntArray(int[] array) {
        if (null == array || array.length == 0) {
            return new int[0];
        }
        int[] newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        return newArray;
    }


    /**
     * 比较两个整型数组
     *
     * @param array01 数组1
     * @param array02 数组2
     * @return 所有相同下标位置的元素相等，返回true
     */
    public static boolean isTwoIntArrayEqual(int[] array01, int[] array02) {
        if (null == array01 || null == array02) {
            return false;
        }

        if (array01.length != array02.length) {
            return false;
        }

        if (array01 == null && array02 == null) {
            return true;
        }

        for (int i = 0; i < array01.length; i++) {
            if (array01[i] != array02[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * 调用Java内库给数组排序排序
     *
     * @param array
     */
    public static void comparatorIntArray(int[] array) {
        Arrays.sort(array);
    }

    /**
     * 位运算方式交换值，这种方式比较骚，感觉是在炫技
     *
     * @param arr 操作的整型数组
     * @param i   操作的索引一
     * @param j   操作的索引二
     */
    public static void swapValByBitOperation(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 借助三方变量方式交换值
     *
     * @param arr 操作的整型数组
     * @param i   操作的索引一
     * @param j   操作的索引二
     */
    public static void swapValByTripartite(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
