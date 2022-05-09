package leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author keyu
 * @since 2022-04-26 12:20
 **/

public class Generate {
    public static void main(String[] args) {
        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> levelList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == 1||j==i) {
                    levelList.add(1);
                } else {
                    levelList.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j));
                }

            }
            result.add(levelList);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
