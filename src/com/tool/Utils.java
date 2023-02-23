package com.tool;


/**
 * @author: yuan
 * @date: 2023/2/23
 * @Description: 工具类
 */
public class Utils {
    /**
     * @author: yuan
     * @date: 2023/2/23 11:29
     * @param: [arr, i, j]
     * @return: int[]
     * @descipton: 数组交换两数。讲数组arr的i下标和j下标的数互换
     */
    public static int[] swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        return arr;
    }
}
