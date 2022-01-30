package sort;

/**
 * @author zakree
 * @since 2022-01-24 15:17
 **/

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j])
                    SortUtil.swap(arr, i, j);
            }
        }
    }
}
