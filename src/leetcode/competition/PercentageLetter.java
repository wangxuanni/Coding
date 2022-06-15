package leetcode.competition;

/**
 * 5.22周赛第一题
 *
 * @author keyu
 * @since 2022-05-22 10:31
 **/

public class PercentageLetter {
    public static void main(String[] args) {

        System.out.println(percentageLetter("foobar", 'o'));
    }

    public static int percentageLetter(String s, char letter) {
        double count = 0.0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter)
                count++;
        }
        double res = count / s.length() * 100.0;
        return (int) res;

    }
}
