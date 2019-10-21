package leetcode.array;

import java.util.HashMap;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-21 17:06
 **/

public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            hashMap.clear();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int d = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if (hashMap.containsKey(d)) {
                    res += hashMap.get(d) * 2;
                    hashMap.put(d, hashMap.get(d) + 1);
                } else {
                    hashMap.put(d, 1);
                }
            }
        }
        return res;
    }

}