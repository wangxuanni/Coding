package sort;

import java.util.Arrays;

/**
 * @description:二路快排+随机选切分点。
 * 随机切分点是为了防止数组在近乎有序的情况下时间复杂度退化成O（n^2）
 * 二路是为了防止大量重复元素的情况，二路快排可以把重复元素均匀的分在两边，而不是堆积在一边，降低效率。
 * @author: wangxuanni
 * @create: 2019-08-03 13:48
 **/
public class QuickSort2 {
    public static void main(String[] args) {
        int[] a = {7, 3, 9};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin >= end)
            return;

        int k = partition2(arr, begin, end);
        quickSort(arr, begin, k - 1);
        quickSort(arr, k + 1, end);
    }

    public static int partition2(int[] arr, int begin, int end) {
        int random = (int) (Math.random() * 100) % (end - begin + 1) + begin;
        swap(arr, random, end);

        int point=begin;
        int l = begin + 1;
        int r = end;

        while(true){
            while(l<=end&&arr[l]<arr[point])l++;
            while(r>=begin&&arr[r]>arr[point])r--;
            if(l>r)break;
            swap(arr,l,r);
            l++;
            r--;
        }
        swap(arr,point,r);
       return r;

    }

    static void swap(int arr[], int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

