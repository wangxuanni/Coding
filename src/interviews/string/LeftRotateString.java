package interviews.string;

public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if (str.trim().equals("") || n > str.length())
            return "";
        String appendEnd = str.substring(0, n);//ȡ�ĵ�ǰȡ������ģ�
        String appendStart = str.substring(n, str.length());
        return appendStart += appendEnd;
    }
}
