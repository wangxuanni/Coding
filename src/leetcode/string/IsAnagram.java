package leetcode.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 实现strStr（）
 * @author keyu
 * @since 2022-04-29 11:05
 **/

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer orDefault = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), ++orDefault);
        }
        for (int i = 0; i < t.length(); i++) {
            Integer count = map.get(t.charAt(i));
            if (count == null) return false;
            if (count == 1) {
                map.remove(t.charAt(i));
            } else {
                map.put(t.charAt(i), --count);
            }
        }
        return map.size() == 0;
    }

}