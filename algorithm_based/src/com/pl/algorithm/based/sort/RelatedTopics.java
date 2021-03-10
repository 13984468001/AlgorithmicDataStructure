package com.pl.algorithm.based.sort;

/**
 * @author LIPIAO
 * @date 2021/3/10 17:42
 * <p>
 * 认识二分法
 * <p>
 * 经常见到的类型是在一个有序数组上，开展二分搜索
 * 但有序真的是所有问题求解时使用二分的必要条件吗？
 * 不
 * 只要能正确构建左右两侧的淘汰逻辑，你就可以二分。
 * <p>
 * 相关题目：
 * 1) 在一个有序数组中，找某个数是否存在
 * 2) 在一个有序数组中，找>=某个数最左侧的位置
 * 3) 在一个有序数组中，找<=某个数最右侧的位置
 * 4) 局部最小值问题
 * <p>
 * 相关题目
 */
public class RelatedTopics {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int target : array) {
            System.out.println(topicso1(array, target));
        }
    }

    /**
     * 在一个有序数组中，找某个数是否存在
     *
     * @param array
     * @param target
     * @return
     */
    public static boolean topicso1(int[] array, int target) {

        if (null == array || array.length == 0) {
            return false;
        }

        // 利用二分查找
        int L = 0, R = array.length - 1, targetIndex = 0;
        while (L < R) {
            //targetIndex = (L + R) / 2;
            //一个数除以二等价于这个数带符号向右移一位，因此上一句可改写为
            //targetIndex = (L + R) >> 1;
            targetIndex = L + ((R - L) >> 1);
            if (array[targetIndex] == target) {
                return true;
            } else if (array[targetIndex] > target) {
                //目标数可能在数组二分后的左边，所以限定右边界
                R = targetIndex - 1;
            } else {
                //目标数可能在数组二分后的右边，限定左边界
                L = targetIndex + 1;
            }
        }

        //为什么取L位置的书来比较，因为L无论如何，它都会大于零，小于数组长度，最终到达目标数位置
        return array[L] == target;
    }

}
