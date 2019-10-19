package Lexical_Addition;

import java.util.*;
import java.lang.*;
import java.io.*;

class v2 {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        long N = Long.parseLong(line[0]);
        long A = Long.parseLong(line[1]);
        long B = Long.parseLong(line[2]);

        final long MAX_LEN = N/A;
        long[] solution = new long[(int) MAX_LEN];

        if (B >= N) {
            System.out.println("YES\n" + N);
        } else {
            long index = MAX_LEN;
            for (; index > 1; index--) {

            }

            if (solution[0] == 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                for (long value : solution) {
                    if (value != 0) {
                        System.out.print(value + " ");
                    }
                }
            }
        }
    }
}
