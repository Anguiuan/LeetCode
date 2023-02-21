package com.zky;

/**
 * @auther: zkyuan
 * @date: 2023/2/21 22:22
 * @description: 二分法
 */
public class Dichotomy {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5,9};
        int result = dichotomyOrderly(arr, 7);
        System.out.println("数组下标为：" + result + "，  值为：" + arr[result]);
    }

    /**
     * @author: zkyuan
     * @Description: 有序二分
     *    一个有序的升序数组arr，在给定一个数num的条件下，找出数组中大于等于num的最左侧的位置，并打印该数的值
     * @Param: [arr, num]
     * @Return: int
     * @DateTime: 2023/2/21 22:26
     */
    public static int dichotomyOrderly(int[] arr, int num) {
        int left = 0, right = arr.length - 1;
        while ((right - left) > 1) {
            if (arr[(left + right) / 2] < num) {
                left = (left + right) / 2;
            } else {
                right = (left + right) / 2;
            }
        }
        if (arr[left] >= num) {
            return left;
        } else {
            return right;
        }
    }

}
