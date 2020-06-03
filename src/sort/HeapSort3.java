package sort;

import java.util.Arrays;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-20 18:22
 **/

public class HeapSort3 {
    public static void main(String[] args) {
        int[] a = {7, 3, 0, 8, 4, 1, 9};
        heapSort3(a);
        System.out.println(Arrays.toString(a));

    }
    static void heapSort3(int[] arr) {
        //n是数组长度
        int n = arr.length;
        // 注意，此时我们的堆是从0开始索引的
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
        for (int i = (n - 1 - 1) / 2; i >= 0; i--)
            shiftDown3(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown3(arr, i, 0);
        }
    }

    static void shiftDown3(int[] arr, int k, int n) {
        while (k * 2 + 1 < n) {
            int j = k * 2 + 1;
            if (j + 1 < n && arr[j + 1] > arr[j]) {
                j += 1;
            }
            if (arr[k] >= arr[j]) break;
            swap(arr, j, k);
            k = j;
        }
    }

    static void swap(int arr[], int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
