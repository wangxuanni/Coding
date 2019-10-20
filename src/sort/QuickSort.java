package sort;

import java.util.Arrays;

/**
 * @description:快速排序
 * @author: wangxuanni
 * @create: 2018-12-03 13:48
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {7, 3, 0, 8, 4, 1, 9};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin >= end)
            return;

        int k = partition(arr, begin, end);
        quickSort(arr, begin, k - 1);
        quickSort(arr, k + 1, end);
    }

    public static int partition(int[] arr, int begin, int end) {
        int random = (int) (Math.random() * 100) % (end - begin + 1) + begin;
        swap(arr, random, end);
        int cutpoint = arr[end];//选择数组的最后一位为切分点
        int count = begin - 1;//记交换的次数

        int l = begin;
        int r = end;
        while (l <= r) {
            if (arr[l] < cutpoint) {//所有的值都与切分点比较
                count++;
                l++;
                swap(arr, count, l);
            }

        }
        for (int j = begin; j < end; j++) {
            if (arr[j] <= cutpoint) {//所有的值都与切分点比较
                swap(arr, ++count, j);
            }
        }
        swap(arr, ++count, end);
        return count;//返回切分点的数组下标
    }

    static void swap(int arr[], int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

