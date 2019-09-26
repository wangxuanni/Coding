package interviews.Array;
//�����˻�����
public class Multiply {
  static   int[] multiply(int[] A) {
        int len = A.length;
        int forword[] = new int[len];
        int backword[] = new int[len];
        int B[] = new int[len];
        forword[0] = 1;
        backword[0] = 1;
        for(int i = 1;i < len; i++){
            //֮ǰ�ĳ˻�����֮��ĳ˻�������������������������Ҫ����
            forword[i] = A[i - 1]*forword[i-1];//�����ǰһ��Ԫ�س���֮ǰ�ĳ˻�
            backword[i] = A[len - i]*backword[i - 1];
        }
        for(int i = 0; i < len; i++){
            B[i] = forword[i] * backword[len - i -1];
        }
        return B;
    }
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5};
        multiply(arr);

    }
}
