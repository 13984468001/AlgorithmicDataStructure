package com.pl.algorithm.based._01_sort;

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
//        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        for (int target : array) {
//            System.out.println(topicso1(array, target));
//        }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


//        int[] array2 = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};
//        System.out.println(array2.length);
//        for (int target : array2) {
//            //System.out.println(target + " = " + topicso2(array2, target));
//            //System.out.println(target + "isSuccess=" + (topicso2(array2, target) == topicso2Test(array2, target)));
//
//
//            System.out.println(target + " = " + topicso3(array2, target));
//            System.out.println(target + "isSuccess=" + (topicso3(array2, target) == topicso3Test(array2, target)));
//        }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


        // 二分查找局部最小值1
//        int[] array3 = {5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1, 2, 3, 4, 5};
//        System.out.println(topicso4(array3));
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        knowDifferentOr();


    }

    /**
     * 在一个有序数组中，找某个数是否存在
     *
     * @param array
     * @param target
     * @return 存在返回true
     */
    public static boolean topicso1(int[] array, int target) {

        if (null == array || array.length == 0) {
            return false;
        }

        // 利用二分查找
        int L = 0, R = array.length - 1;
        while (L < R) {
            int targetIndex = 0;
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

    /**
     * 在一个有序数组中，找>=某个数最左侧的位置
     *
     * @param array
     * @param target
     * @return 返回最左位置的索引
     */
    public static int topicso2(int[] array, int target) {

        if (null == array || array.length == 0) {
            return -1;
        }

        // 利用二分查找
        int L = 0, R = array.length - 1;
        //记录最左位置
        int index = -1;
        while (L <= R) {
            int targetIndex = L + ((R - L) >> 1);
            if (array[targetIndex] >= target) {
                //记录当前数值索引
                index = targetIndex;
                //目标数可能在数组二分后的左边，所以限定右边界
                R = targetIndex - 1;
            } else {
                //目标数可能在数组二分后的右边，限定左边界
                L = targetIndex + 1;
            }
        }

        return index;
    }

    /**
     * 检验topicso2
     *
     * @param array
     * @param target
     * @return target最左侧的位置
     */
    public static int topicso2Test(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= target) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 在一个有序数组中，找<=某个数最右侧的位置
     *
     * @param array
     * @param target
     * @return 返回最左位置的索引
     */
    public static int topicso3(int[] array, int target) {

        if (null == array || array.length == 0) {
            return -1;
        }

        // 利用二分查找
        int L = 0, R = array.length - 1;
        //记录最左位置
        int index = -1;
        while (L <= R) {
            int targetIndex = L + ((R - L) >> 1);
            if (array[targetIndex] <= target) {
                //记录当前数值索引
                index = targetIndex;
                //目标数可能在数组二分后的左边，所以限定右边界
                L = targetIndex + 1;
            } else {
                //目标数可能在数组二分后的右边，限定左边界
                R = targetIndex - 1;
            }
        }

        return index;
    }

    /**
     * 检验topicso3
     *
     * @param array
     * @param target
     * @return target最右侧的位置
     */
    public static int topicso3Test(int[] array, int target) {
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] <= target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 局部最小值问题
     * <p>
     * 经常见到的类型是在一个有序数组上，开展二分搜索
     * 但有序真的是所有问题求解时使用二分的必要条件吗？
     * <p>
     * 不。只要能正确构建左右两侧的淘汰逻辑，你就可以二分。
     * <p>
     * 问题：
     * 给定一任意相邻元素不重复的无序数组，找到其中任意一个局部最小值。
     * （注：局部最小值的定义为该位置的元素小于其左右两个元素，对于首元素，只需小于后一个，尾元素小于前一个即可）
     * ###### 大体思路：
     * 先进行首尾元素判断，若为局部最小值返回即可，否则从两边出发的趋势为下降的。
     *
     * @param array
     * @return 局部最小值的位置
     */
    public static int topicso4(int[] array) {

        if (null == array || array.length == 0) {
            return -1;
        }

        //只有一个元素时，这个元素就是局部最小值，直接返回
        //头部两个元素前一个小于后一个时，前一个就是局部最小值，直接返回
        if (array.length == 1 || array[0] < array[1]) {
            return 0;
        }

        //尾部两个元素后一个小于前一个时，后一个就是局部最小值，直接返回
        if (array[array.length - 1] < array[array.length - 2]) {
            return array.length - 1;
        }

        //以上情况都不满足的情况下，数组头部元素随下标往后移动元素值呈现出下降趋势，相反尾部元素随着下标往前移动元素值呈现出下降趋势，中间则一定存在局部最小值
        int L = 0, R = array.length - 1;
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (array[mid] > array[mid - 1]) {
                //假设数组元素值由左往右递减，当中间位置元素比前一个元素值大时，说明数组呈上升趋势，限定右边界
                R = mid - 1;
            } else if (array[mid] > array[mid + 1]) {
                //假设数组元素值由左往右递减，当中间位置元素比前一个元素值大时，说明数组呈下降趋势，限定左边界
                L = mid + 1;
            } else {
                return array[mid];
            }
        }

        return array[L];
    }

    /**
     * 认识异或
     * <p>
     * 异或运算与顺序无关，满足交换律和结合率
     */
    private static void knowDifferentOr() {
        //认识异或
        // 0 ^ N = N
        //System.out.println("0 ^ 100 = " + (0 ^ 100));
        // N ^ N = 0
        //System.out.println("100 ^ 100 = " + (100 ^ 100));

        //问题一：一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数
//        int[] array4 = {1, 2, 3, 5, 4, 1, 4, 5, 3, 5, 2};
//        int eor = 0;
//        for (int i = 0; i < array4.length; i++) {
//            // 0 ^ a = a;
//            // a ^ b != 0;
//            // 分析：数组中的1,2,3,4都是出现偶数次，所以它们先跟0做异或，然后相互异或，则为0，只有5 => 0 ^ 5 ^ 5 ^ 5 = 5;
//            eor ^= array4[i];
//        }
//        System.out.println(eor);

        //问题二：一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
        int[] array5 = {1, 2, 3, 5, 4, 1, 4, 5, 3, 5, 2, 1};
        int a = 0;
        for (int i = 0; i < array5.length; i++) {
            a ^= array5[i];
        }

        //假设c和d出现了奇数次，c!=d，那么所有元素异或的结果一定等于一个c^一个d，且结果不为0；
        //如上for循环后，a!=0，那么也就是说，在a的二进制编码中一定在某个位上有1，假设是第六位
        //那么这时候，把整个数组分成两大类，一类是元素的第六位为1的，一类是元素的第六位为0的
        //这时候准备一个变量onlyOne，再异或数组中的每一个元素，且只异或第六位为1的那些元素，
        // 那么元素中第六位为1且出现偶数次的数，异或结果为0，依然不会被干扰，只有异或到c或d结果不等0
        // 因此c或者d中有一个就会被抓出来，怎么得到另外一个呢？这里用被抓出来的这个onlyOne跟之前的a异或一下即可得

        //但是我们并不知道找哪一个位，因此我们找出最右边为1的那一位。这是一个道理
        int rightOne = a & (~a + 1);
        int onlyOne = 0;
        for (int i = 0; i < array5.length; i++) {
            //rightOne只有一个位是1，因此一个数与上rightOne，结果不为0时，说明这个数跟rightOne某个相同位置上都是1
            //因此我们就需要找这个元素，然后让它跟0异或
            if ((array5[i] & rightOne) != 0) {
                onlyOne ^= array5[i];
            }
        }

        //当遍历完后我们找到了一个奇数，再把这个奇数跟第一次遍历的结果异或就可以得到另外一个奇数
        System.out.println(onlyOne + "、" + (a ^ onlyOne));

    }

}
