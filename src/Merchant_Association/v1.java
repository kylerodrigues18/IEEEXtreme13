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
        ArrayList<Integer> merchantsPosition;

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

        //init merchant position ArrayList
        int merchantNumber = in.nextInt();
        merchantsPosition = new ArrayList<>();
        for(int i = 0; i < merchantNumber; i++) {
            merchantsPosition.add(in.nextInt());
        }

        int totalCost = 0;
        int merchant = 0;
        int purchaseLocation = 0;
        int sellingLocation = 0;
        int cost = 0;
        for (int m = 0; m < merchantNumber; m++) {

            //finished receiving necessary data, now time to get the answer #killme
            for (int i = 0; i < merchantNumber; i++) {
                //Get and store the merchant initial location
                int merchantInitLocation = merchantsPosition.get(i);

                //Using the initial merchant location, find the routes to travel from it
                ArrayList<Integer> purchaseLoc = routes.get(merchantInitLocation);

                for (int purchase = 0; purchase < purchaseLoc.size(); purchase++) {
                    //Temporarily move the merchant to the purchase location
                    merchantsPosition.set(i, purchaseLoc.get(purchase));

                    //if the purchase location is found in the merchant position, then do nothing since a merchant is located in that city
                    if (merchantsPosition.indexOf(purchaseLoc.get(purchase)) == -1) {
                        //Get the price to buy the goods
                        int tempCost = townPrices[purchaseLoc.get(purchase)];

                        //Create an ArrayList of selling locations from the purchase location
                        ArrayList<Integer> sellingLoc = routes.get(purchaseLoc.get(purchase));

                        for (int sellingPlace : sellingLoc) {
                            //If the selling location is found in the merchant position, then do nothing since a merchant is located in that city
                            if (merchantsPosition.indexOf(sellingPlace) != -1) {
                                int compareCost = townPrices[sellingPlace] - tempCost;
                                if (compareCost > cost) {
                                    cost = compareCost;
                                    merchant = i;
                                    purchaseLocation = purchase;
                                    sellingLocation = sellingPlace;
                                }
                            }
                        }
                    }
                }
                merchantsPosition.set(i, merchantInitLocation);
            }
            merchantsPosition.set(merchant, sellingLocation);
            totalCost += cost;
            cost = 0;
        }
        System.out.println(totalCost);
    }
}
