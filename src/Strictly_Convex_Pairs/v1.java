package Strictly_Convex_Pairs;

import java.util.*;

public class v1 {

    private static ArrayList<Point> points = new ArrayList<>();
    private static ArrayList<Point> polygon = new ArrayList<>();
    private static int pointCount, polygonCount;

    private static int output;

    private static enum Orientation {
        CLOCKWISE,
        COUNTERCLOCKWISE,
        COLINEAR;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        polygonCount = in.nextInt();
        pointCount = in.nextInt();

        for (int i = 0; i < polygonCount; i++) {
            polygon.add(new Point(in.nextInt(), in.nextInt()));
        }

        for (int i = 0; i < pointCount; i++) {
            points.add(new Point(in.nextInt(), in.nextInt()));
        }

        // Finish getting input

        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = i + 1; j < points.size(); j++) {
                int result = checkPoints(points.get(i), points.get(j));
                output += result;
            }
        }

        System.out.println(output);
    }

    static int checkPoints(Point a, Point b) {
        for (int i = 0; i < polygonCount; i++) {
            if (intersect(a, b, polygon.get(i), polygon.get((i + 1) % polygonCount))) {
                return 0;
            }
        }
        return 1;
    }

    // Are the points arranged in a clockwise fashion?
    static Orientation orientation(Point a, Point b, Point c) {
        double orientation = (b.y - a.y) * (c.x - b.x) - (b.x - a.x) * (c.y - b.y);
        if (orientation > 0) {
            return Orientation.CLOCKWISE;
        } else if (orientation == 0) {
            return Orientation.COLINEAR;
        } else {
            return Orientation.COUNTERCLOCKWISE;
        }
    }

    static boolean intersect(Point a, Point b, Point c, Point d) {
        Orientation o1 = orientation(a, b, c);
        Orientation o2 = orientation(a, b, d);
        Orientation o3 = orientation(c, d, a);
        Orientation o4 = orientation(c, d, b);

        return o1 != o2 && o3 != o4;
    }

    static class Point {
        double x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
