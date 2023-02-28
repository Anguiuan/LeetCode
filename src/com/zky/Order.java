package com.zky;

import com.tool.ListNode;
import com.tool.Utils;

/**
 * @author: yuan
 * @date: 2023/2/23
 * @Description: 排序算法
 */
public class Order {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 3, 2, 5, 9, 6, 3, 4, 7, 8, 2, 1, 5};
        System.out.print("冒泡排序结果：");
        int[] bubbling = bubblingOrder(arr);
        for (int num : bubbling) {
            System.out.print(num + " ");
        }
        System.out.print("\n直接插入结果：");
        int[] inse = insertOrder(arr);
        for (int num : inse) {
            System.out.print(num + " ");
        }
        System.out.print("\n折半插入结果：");
        int[] in = insertSort(arr);
        for (int num : in) {
            System.out.print(num + " ");
        }
        System.out.print("\n希尔排序结果：");
        int[] shell = insertSort(arr);
        for (int num : shell) {
            System.out.print(num + " ");
        }
        System.out.print("\n快速排序结果：");
        int[] quickSort = quickSort(arr);
        for (int num : quickSort) {
            System.out.print(num + " ");
        }
        System.out.print("\n选择排序结果：");
        int[] choose = chooseSort(arr);
        for (int num : choose) {
            System.out.print(num + " ");
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
                    Utils.swap(arr, j, j - 1);//交换两数
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    /**
     * @author: yuan
     * @date: 2023/2/27 10:30
     * @param: [arr]
     * @return: int[]
     * @descipton: 折半插入。在进行每一趟寻找待插入位置的操作时，使用折半查找的方式
     */
    public static int[] insertSort(int[] arr) {
        //外层循环控制循环次数
        for (int i = 2; i < arr.length; i++) {
            //临时变量保存待插入元素
            int temp = arr[i];
            //有序列表的左右指针
            int left = 0, right = i - 1;
            //内层循环寻找插入的位置
            while ((right - left) >= 0) {
                int mid = (left + right) / 2;
                if (arr[mid] < temp) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            //在待插入位置，数组整体后移
            for (int j = i; j > left; j--) {
                arr[j] = arr[j - 1];
            }
            //放入元素
            arr[left] = temp;
        }
        return arr;
    }

    /**
     * @author: yuan
     * @date: 2023/2/27 14:47
     * @param: [arr]
     * @return: int[]
     * @descipton: 希尔排序，先让元素基本有序，再用直接插入排序
     */
    public static int[] shellSort(int[] arr) {
        //数组长度
        int n = arr.length;
        //外层循环按相同增量的距离分组
        for (int d = n / 2; d > 0; d = d / 2) {
            //对分组进行直接插入排序
            for (int i = d; i < n; i++) {
                //i位置为待排序判断的元素，i之前为有序集合
                if (arr[i] < arr[i - d]) {
                    //临时中间变量temp、排序控制变量j
                    int temp = arr[i], j = i - d;
                    //在要插入的位置后的数组元素后移
                    for (; j > 0 && temp < arr[j]; j -= d) {
                        arr[j + d] = arr[j];
                    }
                    //插入元素
                    arr[j + d] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * @author: yuan
     * @date: 2023/2/27 16:41
     * @param: [arr, low, high]
     * @return: void
     * @descipton: 快速排序，递归
     */
    public static void quickSort(int[] arr, int left, int right) {
        //递归返回条件
        if (left > right) {
            return;
        }
        //pivot就是基准位
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            //先看右边，依次往左递减
            while (pivot <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (pivot >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                Utils.swap(arr, i, j);
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[left] = arr[i];
        arr[i] = pivot;
        //递归调用左半数组
        quickSort(arr, left, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, right);
    }

    public static int[] quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * @author: yuan
     * @date: 2023/2/28 9:45
     * @param: [arr]
     * @return: int[]
     * @descipton: 简单选择排序
     */
    public static int[] chooseSort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            //内层循环找最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            //如果min的位置发生了变化，则让min与i下标的元素交换
            if (min != i) {
                Utils.swap(arr, i, min);
            }
        }
        return arr;
    }
}
