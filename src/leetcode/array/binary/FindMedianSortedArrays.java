package leetcode.array.binary;

/**
 * 返回两个排序数组的中位数
 *
 * @author keyu
 * @since 2022-05-23 18:03
 **/

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1={1,3};
        int[] nums2={2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //if sum of  two array length is odd,first half equals (sum+1)/2
        int len1 = nums1.length;
        int len2 = nums2.length;

        return findMedianSortedArrays(len1 > len2 ? nums2 : nums1, len1 > len2 ? nums1 : nums2, len1 + len2);
    }

    /**
     * case1 nums1 = [1,3], nums2 = [2]
     * isOdd lensum=2; s=0 e=0 m=0 greaterArrayPointer=1
     * case2 nums1 = [1,2], nums2 = [3,4]
     */
    public static double findMedianSortedArrays(int[] samllerArr, int[] greaterArr, int lenSum) {
        boolean isEven = lenSum % 2 == 0;
        if (isEven) {
            lenSum = lenSum / 2;
        } else {
            lenSum = (lenSum + 1) / 2;
        }
        int start = 0;
        int end = samllerArr.length - 1;
        int max = 0;
        int min = 0;
        while (true) {
            int mid = (start + end) / 2;

            int left1 = mid < 0 ? Integer.MIN_VALUE : samllerArr[mid];
            int right1 = mid + 1 >= samllerArr.length ? Integer.MAX_VALUE : samllerArr[mid + 1];
            int left2 = lenSum - mid - 2 < 0 ? Integer.MIN_VALUE : greaterArr[lenSum - mid - 2];
            int right2 = lenSum - mid - 2 >= greaterArr.length ? Integer.MAX_VALUE : greaterArr[lenSum - mid - 1];
            min = Math.min(right1, right2);

            if (left1 < right2 && left2 < right1) {
                max = Math.max(left1, left2);
                break;
            }
            if (greaterArr[right2] > samllerArr[mid + 1]) {
                //if greaterArr is greater ,samllerArr need more element in first part
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        int median = 0;
        if (isEven) {
            median = (max + min) / 2;
        } else {
            median = max;
        }
        return median;
    }
}
