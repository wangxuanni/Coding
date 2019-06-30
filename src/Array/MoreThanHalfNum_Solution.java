package Array;

/**
 * 数组超过一半的数
 */
public class MoreThanHalfNum_Solution {
    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array==null||array.length<1)
            return 0;
        int count = 1;
        int same = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == same) {
                count++;
            } else {
                if (count == 0) {
                    same = array[i];
                    count = 1;
                }
                count--;
            }
        }
        return count==0?0:same;
    }
}
