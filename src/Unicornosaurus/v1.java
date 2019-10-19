package Unicornosaurus;

import java.util.*;

public class v1 {

    private static int intervalCount;
    private static int superpowerCount;
    private static int plankCount;
    private static boolean[] broken;

    private static ArrayList<Superpower> superpowers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        intervalCount = in.nextInt();
        superpowerCount = in.nextInt();
        plankCount = in.nextInt();

        broken = new boolean[plankCount];
        //Arrays.fill(broken, Boolean.FALSE);
        //Arrays.fill(confirmBroken, Boolean.FALSE);

        for (int i = 0; i < intervalCount; i++) {
            Arrays.fill(broken, in.nextInt(), in.nextInt(), Boolean.TRUE);
        }

        for (int i = 0; i < superpowerCount; i++) {
            superpowers.add(new Superpower(in.nextInt(), in.nextInt(), in.nextInt()));
        }

        // Finish loading input

        System.out.println("-1");
    }

    static class Superpower {

        private int start, stop, cost;

        public Superpower(int start, int stop, int cost) {
            this.start = start;
            this.stop = stop;
            this.cost = cost;
        }

        public int getStart() {
            return start;
        }

        public int getStop() {
            return stop;
        }

        public int getCost() {
            return cost;
        }

        public int getDistance() {
            return stop - start;
        }
    }
}
