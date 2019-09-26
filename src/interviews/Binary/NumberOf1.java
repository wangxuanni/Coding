package interviews.Binary;

import java.util.Scanner;

public class NumberOf1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt();
        System.out.println(NumberOf1(i));
    }
    public static int NumberOf1(int n) {
        int count=0;
        while(n!=0){
            count++;
            n=(n-1)&n;
        }
        return count;
    }
}
