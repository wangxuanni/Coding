package leetcode.dp;

/**
 * @author wangxuanni
 * @since 2021-10-02 15:38
 **/

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr={2,7,9,3,1};
        rob(arr);
    }
    public static int rob(int[] nums) {
        int preTwo=0; int preOne=0;
        for (int i = 0; i < nums.length; i++) {
            int chooseSumOrCur=Math.max(preTwo+nums[i],preOne);
            preTwo=preOne;
            preOne=chooseSumOrCur;
        }
        return preOne;
    }
}
