package sort;

import java.util.Arrays;

/**
 * @description:堆排序
 * @author: wangxuanni
 * @create: 2019-08-03 13:48
 **/

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {0,4, 2, 8,2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void heapSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            heapInsert(i, arr);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapIfy(1, arr,size);
            swap(arr, 1, --size);
        }
    }

    static void heapInsert(int i, int[] arr) {
        int parent = i / 2;
        while (arr[parent] > arr[i]) {
            swap(arr, i, parent);
            i = parent;
        }
    }

    static void heapIfy(int index, int[] arr,int size) {
        int l = index * 2;
        while (l < size) {
            int largest =l+1<size&&arr[l] < arr[l+1] ? l : l+1;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index)
                break;
            swap(arr, index, largest);
            index = largest;
            l = index * 2;
        }
    }

    static void swap(int arr[], int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
