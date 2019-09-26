package offer.LinkList;

import java.util.LinkedList;

public class LastRemaining {
    public int lastRemaining(int n, int m) {
        LinkedList<Integer> link=new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            link.add(i);
        }int bt=0;
        while(link.size()>1){
            bt=(bt+m-1)%link.size();
            link.remove(bt);
        }
        return link.size()==1?link.get(0):-1;
    }
}
