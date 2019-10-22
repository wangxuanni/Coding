package leetcode.array;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-21 19:32
 **/

public class ContainsNearbyDuplicate3 {
    public static void main(String[] args) {
        int[]arr={-1,2147483647};

        System.out.println(containsNearbyDuplicate3(arr,1,2147483647));
    }
    public static boolean containsNearbyDuplicate3(int[] nums, int k,int t) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                // if (set.contains(nums[i])) return true;
                int v=nums[i];
                /**
                 * 在 set 上查找大于等于x的最小的数，如果s−x≤t则返回 true
                 * 在 set 上查找小于等于x的最大的数，如果x−g≤t则返回 true
                 * 1,5,9,1,5,9
                 */
                Integer ceiling = set.ceiling(v);
                //v-ceiling v都比ceiling小是还减，会减出一个负数来
                if (ceiling != null && ceiling<=t+v)return true;
                Integer floor = set.floor(v);//最大的一个数
                if (floor != null &&v<=t+floor)return true;
                set.add(v);
                if (set.size() == k +1) {
                    set.remove(nums[i-k]);
                }

            }
            return false;
        }
    }