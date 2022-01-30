package sort;

/**
 * @author zakree
 * @since 2022-01-24 15:15
 **/

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {//i[最大坐标~最小坐标]
            for (int j = 0; j < i; j++) {//j[最小坐标~i-1]
                if (arr[j] > arr[j + 1])
                    SortUtil.swap(arr, j, j + 1);
            }
        }
    }
}
