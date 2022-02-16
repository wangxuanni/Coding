package offer.dp;

/**
 * @author keyu
 * @since 2022-02-04 18:51
 **/

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int lenMax = 0;
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            char indexC = s.charAt(i);
            int indexValue = s.indexOf(String.valueOf(indexC));
            if (indexValue >= 0) lenMax++;
            else lenMax=0;
            max= Math.max(lenMax, max);
        }
        return max;
    }

}
