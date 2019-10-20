package sort;

import java.util.Arrays;

/**
 * @description:以下标为1排序，即不使用下标0，优点是找父子节点更容易
 * @author: wangxuanni
 * @create: 2019-10-20 17:20
 **/

public class HeapSort2 {
    public static void main(String[] args) {
        int[] a = {7, 3, 0, 8, 4, 1, 9};
        heapSort2(a);
        System.out.println(Arrays.toString(a));

    }

    static void heapSort2(int[] arr) {
        if(arr.length<=0){return;}
        int[] newarr = new int[arr.length + 1];
        for (int i = 1; i < newarr.length; i++) {
            newarr[i] = arr[i - 1];
            ShiftUp(newarr,i );
        }
        swap(newarr, 1, newarr.length - 1);

        for (int i = newarr.length - 2; i > 0; i--) {

            ShiftDown(newarr,1,i);
            swap(newarr, 1, i);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i]=newarr[i+1];
        }


    }

    static void ShiftUp(int[] arr,int k) {
        while (k > 1 && arr[k] > arr[k / 2]) {
            swap(arr, k, k / 2);
            k = k / 2;
        }
    }

    static void ShiftDown(int[] arr,int k, int n) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j + 1 <= n && arr[j + 1] > arr[j]) {
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
