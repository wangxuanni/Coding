package offer.Array;

import sort.SortUtil;

import java.util.Arrays;

/**
 * @author keyu
 * @since 2022-02-10 17:28
 **/

public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1};
        System.out.println(Arrays.toString(getLeastNumbers1(arr, 0, arr.length - 1)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        System.out.println("arr"+Arrays.toString(arr));
        int[] result = getLeastNumbers1(arr, 0, arr.length - 1);
        return Arrays.copyOfRange(result, 0, k);
    }

    public static int[] getLeastNumbers1(int[] arr, int begin, int end) {
        if (begin >= end) {
            return null;
        }

        int k = sort(arr, begin, end);
        getLeastNumbers1(arr, begin, k - 1);
        getLeastNumbers1(arr, k + 1, end);
        return arr;
    }

    public static int sort(int[] arr, int begin, int end) {
        int s = begin;
        int e = end ;
        while (s < e) {
            while (s < e && arr[s] <= arr[end]) s++;
            while (s < e && arr[e] >= arr[end]) e--;
            SortUtil.swap(arr, s, e);
        }
        SortUtil.swap(arr, s, end);
        return s;
    }

}
