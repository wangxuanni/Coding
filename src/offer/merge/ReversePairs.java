package offer.merge;

/**
 * 数组中的逆序对
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 *
 * @author keyu
 * @since 2022-03-21 18:31
 **/

public class ReversePairs {
    int[] arr;
    int result = 0;

    public int reversePairs(int[] nums) {
        this.arr = nums;
        merge(0, nums.length - 1);
        return this.result;

    }

    public void merge(int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        merge(start, mid);
        merge(mid + 1, end);
        mergeSort(start, mid, end);
    }

    public void mergeSort(int start, int mid, int end) {
        int[] help = new int[end - start + 1];
        int s = start, f = mid + 1, count = 0;
        while (s <= mid && f <= end) {
            if (arr[s] <= arr[f]) {
                help[count++] = arr[s++];
            } else {
                this.result += mid - s + 1;
                help[count++] = arr[f++];
            }
        }
        while (s <= mid) {
            help[count++] = arr[s++];
        }
        while (f <= end) {
            help[count++] = arr[f++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[i + start] = help[i];
        }

    }
}