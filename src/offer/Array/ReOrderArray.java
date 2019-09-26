package offer.Array;

public class ReOrderArray {
    public void reOrderArray(int [] array) {
        int star=0;
        int end=array.length-1;
        while(star<end){
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
