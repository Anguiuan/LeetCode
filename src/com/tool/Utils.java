package com.tool;

/**
 * @auther: zkyuan
 * @date: 2023/2/22 22:19
 * @description: 交换两数
 */
public class Utils {
    /**
     * @author: zkyuan
     * @Description: 交换两数
     * @Param: [arr, i, j]
     * @Return: int[]
     * @DateTime: 2023/2/22 22:17
     */
    public static int[] swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        return arr;
    }
}
