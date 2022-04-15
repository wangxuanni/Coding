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
 * @since 2022-03-25 16:16 判断字符串的内容
 **/

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List orDefault = map.getOrDefault(s, new ArrayList<>());
            orDefault.add(strs[i]);
            map.put(s,orDefault);
        }
        return new ArrayList<List<String>>(map.values());
    }
}