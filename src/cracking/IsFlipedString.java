package cracking;

/**
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * @author wangxuanni
 * @since 2021-12-29 17:36
 **/

public class IsFlipedString {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() &&( s1 + s1).contains(s2);

    }
}
