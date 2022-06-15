package leetcode.hashmap;

import java.util.Arrays;

/**
 * 分发饼干
 * @author keyu
 * @since 2022-05-11 16:28
 **/

public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int sIndex = 0;
        for (int i = 0; i < g.length; i++) {
            while (sIndex < s.length && g[i] > s[sIndex]) {
                sIndex++;
            }
            if (sIndex == s.length) break;
            result++;
            sIndex++;

        }
        return result;
    }
}
