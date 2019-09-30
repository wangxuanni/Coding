package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-09-28 23:00
 **/

public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(list);
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list1 = new ArrayList<>();

        if (n <= 1) {
            list1.add("()");
            return list1;
        }

        List<String> list = generateParenthesis(n - 1);
        Set<String> set = new HashSet<>();

        for (String s : list) {
            set.add(s + "()");
            set.add("()" + s);
            set.add("(" + s + ")");
        }
        List<String> result = new ArrayList<>();
        for (String s : set) {
            result.add(s);
        }
        return result;
    }
}
