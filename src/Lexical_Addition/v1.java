package Lexical_Addition;
// Don't place your source in a package

import java.util.*;
import java.lang.*;

// Please name your class Main
class v1 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String s = "YES/n";
        int size = in.nextInt();
        int min = in.nextInt();
        int max = in.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (size(arrayList) < size) {
            arrayList.add(max);
        }

        while (size(arrayList) <= size && size(arrayList) != 0) {
            if (size(arrayList) == size) {
                s += updateAnswer(s, arrayList);
                if (arrayList.get(arrayList.size() - 1) - 1 < min) {
                    arrayList.remove(arrayList.size() - 1);
                } else {
                    int number = arrayList.get(arrayList.size() - 1) - 1;
                    arrayList.remove(arrayList.size() - 1);
                    arrayList.add(number);
                }
            } else {
                if (arrayList.get(arrayList.size() - 1) - 1 < min) {
                    arrayList.remove(arrayList.size() - 1);
                } else {
                    int number = arrayList.get(arrayList.size() - 1) - 1;
                    arrayList.remove(arrayList.size() - 1);
                    arrayList.add(number);
                }
            }
        }

        if (s.length() <= 5) {
            System.out.println("NO");
        } else {
            System.out.println(s);
        }

    }

    public static int size(ArrayList<Integer> arrayList) {
        int size = 0;
        for (int a : arrayList) {
            size += a;
        }
        return size;
    }

    public static String updateAnswer(String s, ArrayList<Integer> integers) {
        for (int i : integers) {
            s += i + " ";
        }
        s = s.substring(0, s.length() - 1);
        s += "/n";
        return s;
    }
}