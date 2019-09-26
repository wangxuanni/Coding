package offer.string;

public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        short []i=new short['z'+1];
        char[] carr=str.toCharArray();
        for(char c:carr){
            i[(int)c]++;
        }
        for(int j=0;j<carr.length;j++){
            if(i[(int)carr[j]]==1){
                return j;
            }
        }
        return -1;
    }
}
