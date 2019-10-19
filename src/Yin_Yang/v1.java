package Yin_Yang;

import java.util.Scanner;

public class v1 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String answer = "";
        int length = in.nextInt();
        while (answer.length() <= (length / 2) - 2) {
            answer = "Y" + answer + "y";
        }
        String temp = answer;
        if (length % 2 == 1) {
            answer += "y";
        }
        while (temp.length() > 0) {
            answer += temp.substring(temp.length() - 1);
            temp = temp.substring(0, temp.length() - 1);
        }
        if (length == 3) {
            answer = "YyY";
        }
        if (length == 2) {
            answer = "YY";
        }
        if (length == 1) {
            answer = "y";
        }
        if (answer.length() != length) {
            answer = "Y" + answer + "Y";
        }
        System.out.println(answer);
    }
}
