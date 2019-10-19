package Lexical_Addition;

import java.util.*;
import java.lang.*;
import java.io.*;

class v2 {

    private static long MAX_LEN;
    private static long result, min, max;

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        result = Long.parseLong(line[0]);
        min = Long.parseLong(line[1]);
        max = Long.parseLong(line[2]);

        MAX_LEN = result/min;

        if (max >= result) {
            System.out.println("YES\n" + result);
        } else {
            ArrayList<Long> solution = new ArrayList<>();
            solution = guessSol(solution, max);

            if (solution == null) {
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

    private static ArrayList<Long> guessSol(ArrayList<Long> array, long running) {

        if (running < min || array.size() > MAX_LEN) {
            return null;
        }

        long remainder = result - add(array) - running;
        if (remainder > min && remainder < max) {
            array.add(running);
            return array;
        } else {
            ArrayList<Long> guess = null;
            for (int i = 1; i <= max - min && guess == null; i++) {
                guess = guessSol(array, running - i);
            }
            return guess;
        }
    }

    private static long add(ArrayList<Long> array) {
        long result = 0;
        for (long val : array) {
            result += val;
        }
        return result;
    }
}
