package cracking;

/**
 * @author keyu
 * @since 2021-12-29 10:18
 **/

public class ReplaceSpaces {
    public static String replaceSpaces(String S, int length) {
        //先把字符串转化为字符数组
        char[] chars = S.toCharArray();
        int index = chars.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            //如果遇到空格就把他转化为"%20"
            if (chars[i] == ' ') {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            } else {
                chars[index--] = chars[i];
            }
        }
        return new String(chars, index + 1, chars.length - index - 1);
    }

    public static void main(String[] args) {
        String mr_john_smith____ = replaceSpaces("Mr John Smith    ", 13);
        System.out.println("result:"+mr_john_smith____);
    }
}
