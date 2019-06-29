package Array;
//构建乘积数组
public class Multiply {
  static   int[] multiply(int[] A) {
        int len = A.length;
        int forword[] = new int[len];
        int backword[] = new int[len];
        int B[] = new int[len];
        forword[0] = 1;
        backword[0] = 1;
        for(int i = 1;i < len; i++){
            //之前的乘积数和之后的乘积数都不包括本来的数，所以要乘上
            forword[i] = A[i - 1]*forword[i-1];//数组的前一个元素乘上之前的乘积
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
