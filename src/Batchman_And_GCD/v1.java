package Batchman_And_GCD;

import java.util.*;
import java.lang.*;
import java.io.*;

public class v1 {

    private static int[] integers;

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int intCount = in.nextInt();
        int seqSize = in.nextInt();
        integers = new int[intCount];

        for (int i = 0; i < intCount; i++) {
            integers[i] = in.nextInt();
        }

        // Finished loading variables


    }

    // Isaiah Rondeau signing out right here
    static int[][] getSubsets(int[] set, int seqSize) {
        int[][] returnSet = new int[(int) Math.pow(2, set.length)][set.length];


        return returnSet;
    }

    // Greatest common divisor of an array of numbers
    static int gcd(int[] arr, int len) {
        int result = arr[0];
        for (int i = 1; i < len; i++) {
            result = gcd(arr[i], result);
        }
        return result;
    }

    // Greatest common divisor
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
