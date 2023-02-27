package com.zky;

public class Test {
    /**
     * @author: yuan
     * @date: 2023/1/4
     * Description:  测试算法
     */
    public static void main(String[] args) {
        /*int[] nums1 = {1,2,6,7,9};
        int[] nums2 = {3,5,8,10};
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        double d = findMedianSortedArrays.findMedianSortedArrays(nums1,nums2);
        System.out.println(d);*/
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"  ");

        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


}

