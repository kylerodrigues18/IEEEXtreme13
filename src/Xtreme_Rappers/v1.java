package Xtreme_Rappers;

// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class v1 {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int answer = 0;
        int counter = 0;
        int a = 0;
        int b = 0;
        try {
            a = in.nextInt();
            b = in.nextInt();
        } catch (Exception e) {
            counter++;
            System.out.print(0);
        }
        while(a + b > 2 && a >= 1 && b >= 1) {
            if(a > b) {
                a = a - 2;
                b = b - 1;
            } else {
                b = b - 2;
                a = a - 1;
            }
            answer++;
        }
        if (counter == 0) {
            System.out.print(answer);
        }
    }
}
