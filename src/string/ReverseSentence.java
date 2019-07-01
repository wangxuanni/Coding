package string;

public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str.trim().equals("")) {
            return str;
        }
        String[] sarr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = sarr.length - 1; i >= 0; i--) {
            if (i == 0) {
                sb.append(sarr[i]);
            } else {
                sb.append(sarr[i] + " ");
            }
        }
        return sb.toString();
    }
}
