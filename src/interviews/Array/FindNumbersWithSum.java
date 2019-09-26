package interviews.Array;

import java.util.ArrayList;

/**
 * �����в�����������ʹ�����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
 * ˼·������ͷβָ�����м��ƶ���ֻ��e--��s++
 */
public class FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list=new  ArrayList<Integer>();
        if(array.length<=1)
            return list;
        int s=0,e=array.length-1;
        while(s<e){
            int add= array[s]+array[e];
            if(sum==add){
                list.add(array[s]);
                list.add(array[e]);
                return list;//û���������г�ʱ
            }else if(add>sum){
                e--;
            }else{
                s++;
            }
        }
        return list;
    }
}
