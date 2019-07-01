package Array;

public class Find {

    public boolean Find(int target, int[][] array) {
        int l = 0;
        int h = array.length - 1;
        while (l < array[0].length && h >= 0) {
            if (array[l][h] == target) {
                return true;
            } else if (array[l][h] > target) {
                h--;
            } else {
                l++;
            }
        }
        return false;
    }
}
