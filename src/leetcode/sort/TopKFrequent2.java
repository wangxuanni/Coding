package leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/submissions/
 * Top K Frequent Elements
 *
 * @author keyu
 * @since 2022-05-04 18:52
 **/
public class TopKFrequent2 {
    public static int[] topKFrequent(int[] nums, int k) {
        //cuz number's Frequent <= nums.length
        ArrayList<Integer>[] numFrequent = new ArrayList[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        int frequent = 0;
        for (Integer integer : nums) {
            frequent = map.getOrDefault(integer, 0);
            map.put(integer, frequent+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ArrayList<Integer> list = numFrequent[entry.getValue()];

            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(entry.getKey());
            numFrequent[entry.getValue()] = list;
        }
        int cur = numFrequent.length - 1;
        int curK = 0;
        while (curK < k) {
            while (cur >= 0 && numFrequent[cur] == null) {
                cur--;
            }
            ArrayList<Integer> list = numFrequent[cur--];
            for (Integer i : list) {
                result[curK++] = i;
                if (curK >= k) break;
            }
        }
        return result;

    }
}