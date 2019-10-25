package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {10, 4, 6, 9, 3, 8};
        mergeSort(a, 0, a.length - 1);
        Arrays.toString(a);
    }
    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }


    public static void mergeSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(arr, begin, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, begin, mid, end);
        }
    }

    public static void merge(int[] array1, int low, int mid, int high) {
     int[] array2= array2 = new int[array1.length];
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (array1[i] <= array1[j])
                array2[k++] = array1[i++];
            else
                array2[k++] = array1[j++];
      //      System.out.println(Arrays.toString(array2));
        }
      //  System.out.println(Arrays.toString(array1));

        while (i <= mid)
            array2[k++] = array1[i++];

        while (j <= high)
            array2[k++] = array1[j++];

        for (i = low; i <= high; i++) {
            array1[i] = array2[i];
        }
      //  System.out.println(Arrays.toString(array1));
    }
}

