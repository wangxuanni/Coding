package sort;

import java.util.Arrays;

/**
 * @description:非递归的归并排序。
 * @author: wangxuanni
 * @create: 2019-10-19 00:12
 **/

public class MergeSortBT {
    public static void main(String[] args) {
        int[] a = {10, 4, 6, 9, 3, 8};
        mergeSort(a,  a.length);
        Arrays.toString(a);
    }

    public static void mergeSort(int[] arr, int n) {
        for (int sz = 1; sz < n; sz*=2) {
            for (int i = 0; i+sz-1<n; i+=sz+sz) {
                merge(arr,i,i+sz-1,Math.min(i+sz+sz-1,n-1));
            }
        }
    }

    public static void merge(int[] array1, int low, int mid, int high) {
        int[] array2 = array2 = new int[array1.length];
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (array1[i] <= array1[j])
                array2[k++] = array1[i++];
            else
                array2[k++] = array1[j++];
       //     System.out.println(Arrays.toString(array2));
        }
    //    System.out.println(Arrays.toString(array1));
        while (i <= mid)
            array2[k++] = array1[i++];

        while (j <= high)
            array2[k++] = array1[j++];

        for (i = low; i <= high; i++) {
            array1[i] = array2[i];
        }
     //   System.out.println(Arrays.toString(array1));
    }
}
