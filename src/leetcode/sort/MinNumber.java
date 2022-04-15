package leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 字符串组成最小的数
 * @author keyu
 * @since 2022-03-25 17:15
 **/

public class MinNumber {
    public static void main(String[] args) {
        String s1 = "100";
        String s2 = "9";
        System.out.println(s1.compareTo(s2));//-9
    }

    public static String minNumber(int[] nums) {
        // 输入: [3,30,34,5,9]
        //输出: "3033459"
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(final String o1, final String o2) {
                return Integer.valueOf(o1 + o2) - Integer.valueOf(o2 + o1);

            }
        });


        String result = "";
        for (String num : strs) {
            result += nums;
        }
        return result.toString();
    }
}