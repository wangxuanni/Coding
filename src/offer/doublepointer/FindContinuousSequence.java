package offer.doublepointer;

import java.util.ArrayList;


public class FindContinuousSequence {


    public static ArrayList<ArrayList<Integer> > findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int plow = 1,phigh = 2;
        while(phigh > plow){
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
            }else if(cur < sum){
                phigh++;
            }else{
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
