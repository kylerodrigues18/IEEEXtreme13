package Xtreme_Rappers;

import java.math.BigInteger;
import java.util.Scanner;

public class v2 {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long wordsFirst = scanner.nextLong();
        long wordsSecond = scanner.nextLong();

        if (wordsFirst < wordsSecond) {

            long store = wordsFirst;
            wordsFirst = wordsSecond;
            wordsSecond = store;
        }

        if (wordsFirst >= wordsSecond * 2) System.out.println(wordsSecond);

        else {
            long difference = wordsFirst - wordsSecond;

            wordsFirst -= difference * 2;
            difference += (long) (2.0 / 3 * wordsFirst);


            System.out.println(difference);
        }
    }
}