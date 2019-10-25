package sort;

import java.util.Arrays;

public class QuickSort3 {
    public static void main(String[] args) {
        int[] a = {7, 3, 9};
        partition3(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }



    public static void partition3(int[] arr, int begin, int end) {
        if (begin >= end)
            return;

   /*     int random =( (int) (Math.random() * 100)) % (end - begin + 1) + begin;
        swap(arr, random, begin);*/

        int lt =begin;
        int gt=end;
        int i=begin+1;
        while(i<=gt){
            if(arr[i]<arr[begin]){
                swap(arr,lt,i);
                i++;
                lt++;
            }else if(arr[i]>arr[begin]){
                swap(arr,gt,i);
                gt--;
            }else{
                i++;
            }
        }
     //   swap(arr,begin,lt);

        partition3(arr, begin, lt-1);
        partition3(arr, gt+1, end);
    }

    static void swap(int arr[], int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

