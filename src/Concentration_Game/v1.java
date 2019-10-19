package Concentration_Game;

import java.util.*;
import java.lang.Exception;
import java.io.*;

public class v1 {

    private static HashMap<Integer, Card> knownValues = new HashMap<>();
    private static boolean[] correctGuesses;
    private static int pairsMatched = 0;
    private static int guessIndex = 1;

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        final int pairs = in.nextInt();
        knownValues = new HashMap<>();
        correctGuesses = new boolean[pairs*2 + 1];

        while (pairsMatched != pairs) {
            int guess1 = guessFrom();
            int guess2 = guessFrom();
            System.out.println(guess1 + " " + guess2);

            String line = "";
            while (line.equals("")) {
                line = in.nextLine();
            }
            if (line.equals("MATCH")) {
                knownValues.remove(guess1);
                knownValues.remove(guess2);
                correctGuesses[guess1] = true;
                correctGuesses[guess2] = true;
                pairsMatched += 1;
            } else if (line.equals("-1")) {
                System.exit(0);
            } else {
                String[] cards = line.split(" ");
                int val1 = Integer.parseInt(cards[0]);
                int val2 = Integer.parseInt(cards[1]);
                if (knownValues.containsKey(val1)) {
                    System.out.println(knownValues.get(val1).getPosition() + " " + guess1);
                    System.out.flush();
                    in.nextLine();  // Ignore next input line
                    correctGuesses[knownValues.get(val1).getPosition()] = true;
                    correctGuesses[guess1] = true;
                    knownValues.remove(val1);
                    pairsMatched += 1;
                } else {
                    knownValues.put(val1, new Card(guess1));
                }

                if (knownValues.containsKey(val2)) {
                    System.out.println(knownValues.get(val2).getPosition() + " " + guess2);
                    System.out.flush();
                    in.nextLine();  // Ignore next input line
                    correctGuesses[knownValues.get(val2).getPosition()] = true;
                    correctGuesses[guess2] = true;
                    knownValues.remove(val2);
                    pairsMatched += 1;
                } else {
                    knownValues.put(val2, new Card(guess2));
                }
            }

        }

        System.out.println("-1");
    }

    static int guessFrom() {
        for (int i = guessIndex; i <= correctGuesses.length; i++) {
            if (!correctGuesses[i]) {
                guessIndex = i + 1;
                return i;
            }
        }
        return -1;
    }

    static class Card {
        int position;

        Card(int position) {
            this.position = position;
        }

        public int getPosition() {
            return position;
        }
    }
}
