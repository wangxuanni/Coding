package cracking;

/**
 * @author keyu
 * @since 2021-12-29 10:18
 **/

public class ReplaceSpaces {
    public String replaceSpaces(String S, int length) {
        if (S == null || S.length() == 0)
            return S;
        char[] chars = S.toCharArray();
        int index = S.length() - 1;
        for (int i = length - 1; i >= 0; i--) {
            char c = chars[i];
            if (c == ' ') {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            } else {
                chars[index--] = c;
            }

        }
        index++;
        return new String(chars, index, chars.length - index);
    }
}
