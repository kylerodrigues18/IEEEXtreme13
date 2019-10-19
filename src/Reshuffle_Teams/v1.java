package Reshuffle_Teams;

import java.util.ArrayList;
import java.util.Scanner;

public class v1 {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int numInput = in.nextInt();
        ArrayList<String> input = new ArrayList<>();
        for(int i = 0; i < numInput; i++) {
            String temp = in.nextLine();
            char[] chars = temp.toCharArray();
            ArrayList<char[]> arrayList = new ArrayList<>();
            String s = "";
            for(int c = 0; c < chars.length - 1; c++) {
                if(chars[c] == chars[c + 1]) {
                    s += chars[c];
                } else {
                    if(s.length() == 0) {
                        s = "" + chars[c];
                        arrayList.add(s.toCharArray());
                        s = "";
                    } else {
                        arrayList.add(s.toCharArray());
                        s = "";
                    }
                }
            }
        }
    }
}
