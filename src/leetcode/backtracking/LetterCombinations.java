package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2020-04-27 10:55
 **/

public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23").toString());
    }

    private static final String[] KEYS = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        if("".equals(digits)||digits.length()==0)return new ArrayList<>();
        List<String> list = new ArrayList<>();
        backtracking(list,digits,new StringBuffer(""));
        return list;


    }

    public static void backtracking(List<String> list,String digits,StringBuffer pre) {
        if (pre.length()>=digits.length()){
            list.add(pre.toString());
            return;
        }
        //digits中的数字是个字符串，想转成整形，要减去a
        int posit= digits.charAt(pre.length()) - '0';
        String key = KEYS[posit-1];
        for (int i = 0; i < key.length(); i++) {
            pre.append(key.charAt(i));
            backtracking(list,digits,pre);
            pre.deleteCharAt(pre.length()-1);
        }

    }
}
