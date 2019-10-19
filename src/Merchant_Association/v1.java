package Merchant_Association;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class v1 {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int numTowns = in.nextInt();
        int[] townPrices = new int[numTowns];
        HashMap<Integer, ArrayList<Integer>> routes = new HashMap<>();
        int[] merchantsPosition;

        //init prices array
        for(int i = 0; i < numTowns; i++) {
            townPrices[i] = in.nextInt();
        }

        for (int i = 1; i <= numTowns; i++) {
            routes.put(i, new ArrayList<>());
        }

        //init ArrayList of routes
        for(int i = 1; i < numTowns; i++) {
            int from = in.nextInt();
            int to = in.nextInt();

            routes.get(from).add(to);
            routes.get(to).add(from);
        }

        //init merchant position array
        int merchantNumber = in.nextInt();
        merchantsPosition = new int[merchantNumber];
        for(int i = 0; i < merchantNumber; i++) {
            merchantsPosition[i] = in.nextInt();
        }

        //finished receiving necessary data, now time to get the answer #killme
    }
}
