package com.yc;

/**
 * Description: Ww
 * Author: heyv
 * Time: 2023 2023/7/31 16:41
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{-12, 3, 2, 34, 5, 8, 1}; // 冒泡排序

        // 冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // 输出排序结果
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
