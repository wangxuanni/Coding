package interviews.Array;

/**
 * ���������������ǰ�棬ż���ź���
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        //ǰ�治��Ϊż�����治��Ϊ��
        int star=0;
        int end=array.length-1;
        while(star<end){//��Ҫ����п��ܻᳬ��
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
