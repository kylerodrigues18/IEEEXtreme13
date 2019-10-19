package Merchant_Association;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class v1 {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int numTowns = in.nextInt();
        int[] townPrices = new int[numTowns];
        ArrayList<HashMap> routes = new ArrayList<>();
        int[] merchantsPosition;

        //init prices array
        for(int i = 0; i < numTowns; i++) {
            townPrices[i] = in.nextInt();
        }

        //init ArrayList of routes
        for(int i = 0; i < numTowns - 1; i++) {
            HashMap hashMap = new HashMap();
            hashMap.put(in.nextInt(), in.nextInt());
            routes.add(hashMap);
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
