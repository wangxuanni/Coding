package interviews.Array;

/**
 * ���������������
 * max�������Ƿ�ֹ ������һ�����������������棬������Ͳ�û��С�ڸ�����
 * ���統sum=18��max=18����һ������-5.���û��max����ȥ֮�������֮ǰ���м���ܻ���ֵ����ֵ��
 */
public class FindGreatestSumOfSubArray {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0)
            return 0;
        int sum = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (sum >= 0)////֮ǰ�ĺ�С���㣬������ֱ������һ��
                sum += array[i];
            else
                sum = array[i];
            if (sum > max) {//��ֹ������һ������
                max = sum;
            }
        }
        return max;
    }

    /**
     *��̬�滮
     */
    public  int FindGreatestSumOfSubArray2(int[] array) {
        int res = array[0]; //��¼��ǰ����������ĺ͵����ֵ
        int max=array[0];   //����array[i]�������������ֵ
        for (int i = 1; i < array.length; i++) {
            max=Math.max(max+array[i], array[i]);
            res=Math.max(max, res);
        }
        return res;
    }
}
