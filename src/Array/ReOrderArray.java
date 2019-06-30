package Array;

/**
 * 数组调整到奇数放前面，偶数放后面
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        //前面不能为偶，后面不能为奇
        int star=0;
        int end=array.length-1;
        while(star<end){//不要相等有可能会超过
            if(array[star]%2==0&&array[end]%2!=0){
                int t=array[star];
                array[star]=array[end];
                array[end]=t;
            }else if(array[end]%2==0){
                end--;
            }else if(array[star]%2!=0){
                star++;
            }
        }
    }
}
