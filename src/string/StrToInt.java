package string;

public class StrToInt {
    public int StrToInt(String str) {
        if(str==null||str.length()<=0)
            return 0;
        char []arr=str.toCharArray();
        int fu=0;
        int sum=0;
        if(arr[0]=='-')
            fu=1;
        for(int i=fu;i<arr.length;i++){
            if(arr[i]=='+'){
                continue;
            }
            if(arr[i]<48||arr[i]>57){
                return 0;
            }
            sum=sum*10+arr[i]-48;

        }
        return fu==1?sum*-1:sum;
    }
}
