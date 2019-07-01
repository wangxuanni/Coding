package string;

public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if (str.trim().equals("") || n > str.length())
            return "";
        String appendEnd = str.substring(0, n);//取的到前取不到后的！
        String appendStart = str.substring(n, str.length());
        return appendStart += appendEnd;
    }
}
