package offer.Other;

public class JumpFloor {
    public int JumpFloor(int target) {
        if(target==1||target==2){
            return target;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
}
