package com.zky;

import com.tool.Utils;

/**
 * @author: yuan
 * @date: 2023/2/23
 * @Description: 排序算法
 */
public class Order {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 9, 6, 3, 4, 7, 8, 2, 1, 5};
        System.out.print("冒泡排序结果：");
        int[] bubbling = bubblingOrder(arr);
        for (int num : bubbling) {
            System.out.print(num);
        }
        System.out.print("\n插入排序结果：");
        int[] inse = insertOrder(arr);
        for (int num : inse) {
            System.out.print(num);
        }
    }

    /**
     * @author: yuan
     * @date: 2023/2/23 11:37
     * @param: [arr]
     * @return: int[]
     * @descipton: 冒泡排序升序
     */
    public static int[] bubblingOrder(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    Utils.swap(arr, j, j - 1);
                }
            }
        }
        return arr;
    }

    /**
     * @author: yuan
     * @date: 2023/2/23 11:48
     * @param: [arr]
     * @return: int[]
     * @descipton: 插入排序
     */
    public static int[] insertOrder(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    Utils.swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return arr;
    }

}
