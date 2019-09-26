package interviews.LinkList.doublepointer;

import java.util.ArrayList;

/**
 * ��ΪS��������������
 */

public class FindContinuousSequence {


    public static ArrayList<ArrayList<Integer> > findContinuousSequence(int sum) {
        //��Ž��
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //������㣬�൱�ڶ�̬���ڵ����ߣ������䴰���ڵ�ֵ�ĺ���ȷ�����ڵ�λ�úʹ�С
        int plow = 1,phigh = 2;
        while(phigh > plow){
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //��ȣ���ô�ͽ����ڷ�Χ����������ӽ������
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
                //�����ǰ�����ڵ�ֵ֮��С��sum����ô�ұߴ�������һ��
            }else if(cur < sum){
                phigh++;
            }else{
                //�����ǰ�����ڵ�ֵ֮�ʹ���sum����ô��ߴ�������һ��
                plow++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer> >list=  findContinuousSequence(100);
        for (ArrayList<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
