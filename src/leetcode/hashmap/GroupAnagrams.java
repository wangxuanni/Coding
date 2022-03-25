package leetcode.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 * @author keyu
 * @since 2022-03-25 16:16
 **/

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if (map.containsKey(s)) {
                map.get(s).add(strs[i]);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s, list);
            }
        }
        for (List<String> strings : map.values()) {
            result.add(strings);

        }
        return result;
    }
}