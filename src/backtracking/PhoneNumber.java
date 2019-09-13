package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-09-12 15:11
 **/

public class PhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23").toString());
    }
    private static final String[] KEYS = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuffer prefix = new StringBuffer();
        f(prefix, digits, result);
        return result;
    }

    public static void f(StringBuffer prefix, String digits, List<String> result) {
        if (prefix.length() == digits.length()) {
            result.add(prefix.toString());
            return;
        }

        int i = digits.charAt(prefix.length())-'0';
        String s = KEYS[i];
        for (char c : s.toCharArray()) {
            prefix.append(c);
           f(prefix,digits,result);
            prefix.deleteCharAt(prefix.length()-1);
        }


    }
}
