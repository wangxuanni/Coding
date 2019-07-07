package Other;

public class JumpFloorII {
    public int JumpFloorII(int target) {
        if(target==1){
            return 1;
        }
        return JumpFloorII(target-1)*2;
    }
}
