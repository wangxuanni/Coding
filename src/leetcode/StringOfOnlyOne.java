package leetcode;

import java.util.Scanner;

/**
 * @description:第一个只出现一次的字符
 * @author: wangxuanni
 * @create: 2019-09-26 12:48
 **/
//Mobvista
public class StringOfOnlyOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.trim().equals("")) {
            System.out.println("");
        }
        char []charA=str.toCharArray();
        byte[]count=new byte[150];

        for (int i = 0; i < charA.length; i++) {
           count[charA[i]-'A']++;
        }boolean has=false;
        for (int i = 0; i < charA.length; i++) {
           if(count[charA[i]-'A']==1){
               System.out.println(i);
               has=true;
               break;
           }
        }if (!has){
            System.out.println(-1);

        }
    }
}
