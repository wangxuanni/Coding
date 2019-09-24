package leetcode.array;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-09-22 16:01
 **/
/*Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].*/
public class TwoSum {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int s = 0;
        int e = nums.length - 1;
        while (s < e) {
            int sum = nums[s] + nums[e];
            if (sum == target) {
                result[0]=s;
                result[1]=e;
                break;
            }else if(sum>target){
                e--;
            }else{
                s++;
            }
        }
        return result;


    }
}
