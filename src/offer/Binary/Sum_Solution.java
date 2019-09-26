package offer.Binary;

public class Sum_Solution {
    public int Sum_Solution(int n) {
        int sum=n;
        boolean r=(sum>0)&&((sum=sum+Sum_Solution(--sum))>0);
        return sum;
    }
}
