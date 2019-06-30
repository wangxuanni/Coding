package Array;

import java.util.ArrayList;

/**
 * 数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 思路：两个头尾指针往中间移动，只能e--或s++
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
                return list;//没有这句会运行超时
            }else if(add>sum){
                e--;
            }else{
                s++;
            }
        }
        return list;
    }
}
