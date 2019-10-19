package Reshuffle_Teams;

import java.util.ArrayList;
import java.util.Scanner;

public class v1 {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int numInput = in.nextInt();
        ArrayList<String> input = new ArrayList<>();
        in.nextLine();
        for(int i = 0; i < numInput; i++) {
            input.add(in.nextLine());
        }
        int counter = 0;
        for (String s: input) {
            counter = 0;
            for(int i = 1; i < s.length(); i++) {
                if(s.charAt(i) != s.charAt(i - 1)) {
                    counter++;
                }
            }
            if(s.charAt(0) == s.charAt(s.length() - 1)) {
                counter--;
            }
            if(s.contains("A")) {
                --counter;
            }
            if(s.contains("B")) {
                --counter;
            }
            if(s.contains("C")) {
                --counter;
            }
            if(s.contains("D")) {
                --counter;
            }
            ++counter;
            if (counter < 0) {
                System.out.println(0);
            } else {
                System.out.println(counter);
            }
        }
    }
}
