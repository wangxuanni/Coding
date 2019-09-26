package interviews.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        int n;
        String s = "";
        ArrayList<Integer> list = new ArrayList<Integer>();
        n = numbers.length;
        for (int i = 0; i < n; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });
        for (int j : list) {
            s += j;
        }
        return s;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        Scanner in = new Scanner(System.in);
        String temp = "";
        temp = in.nextLine();
        if (!temp.trim().equals("")) {
            String[] atr = temp.split(",");

            for (String s : atr) {
                list.add(Integer.valueOf(s));
            }
            String s = "";

            Collections.sort(list, new Comparator<Integer>() {
                public int compare(Integer str1, Integer str2) {
                    String s1 = str1 + "" + str2;
                    String s2 = str2 + "" + str1;
                    return s1.compareTo(s2);
                }
            });
            for (int j : list) {
                s += j;
            }
            System.out.println(s);
        }
    }
}
