package leetcode.hashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 *
 * @author keyu
 * @since 2022-03-29 16:43
 **/

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {

        ArrayList<Integer> result = new ArrayList<>();
        int[] pArr = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;
        }
        StringBuffer pStr = new StringBuffer();
        for (int i = 0; i < pArr.length; i++) {
            pStr.append("$");
            pStr.append(i);
            pStr.append("$");
            pStr.append(pArr[i]);

        }
        int start = 0;
        int e = p.length() - 1;
        while (e < s.length()) {
            int[] sArr = new int[26];

            for (int j = start; j <= e; j++) {
                sArr[s.charAt(j) - 'a']++;
            }
            StringBuffer sStr = new StringBuffer();
            for (int i = 0; i < sArr.length; i++) {
                sStr.append("$");
                sStr.append(i);
                sStr.append("$");
                sStr.append(sArr[i]);
            }
            if (sStr.toString().equals(pStr.toString())) {
                result.add(start);
            }
            start++;
            e++;
        }
        return result;


    }
}

