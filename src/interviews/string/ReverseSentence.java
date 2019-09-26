package interviews.string;

import java.util.Scanner;

public class ReverseSentence {
    public String ReverseSentence(String str) {
        char[] str1={'d','f','w'};
    str=str1.toString();
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.trim().equals("")) {
            System.out.println("");
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
        System.out.println(sb.toString());
    }
}
