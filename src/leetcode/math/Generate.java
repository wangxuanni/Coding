package leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角
 * @author keyu
 * @since 2022-04-26 12:20
 **/

public class Generate {
    public List<List<Integer>> generate(int numRows) {
        //初始化 第一二层
        //从arr的{1~i~len-2}arr[i]=arrHigh[i-1]+arr[i+1]
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> levelFirst = new ArrayList<>(Arrays.asList(1));
        result.add(levelFirst);
        if (numRows==1) {
            return result;
        }
        List<Integer> levelSecond = new ArrayList<>(Arrays.asList(1,1));

        int levelCount = 2;
        while (levelCount < numRows) {
            levelCount++;
            List<Integer> levelBefore = result.get(result.size() - 1);
            Integer[] leveArr = new Integer[levelBefore.size() + 1];
            leveArr[0] = 1;
            leveArr[leveArr.length - 1] = 1;
            for (int i = 1; i < leveArr.length - 1; i++) {
                leveArr[i] = levelBefore.get(i - 1) + levelBefore.get(i);
            }
            List<Integer> levelCur = new ArrayList<>(Arrays.asList(leveArr));
            result.add(levelCur);
        }
        return result;

    }
}