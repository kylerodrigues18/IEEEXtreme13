package Lexical_Addition;
// Don't place your source in a package
import java.util.*;
import java.lang.*;

// Please name your class Main
class v1 {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String s = "YES";
        int size = in.nextInt();
        int min = in.nextInt();
        int max = in.nextInt();
        int counter = Math.max(min, max);
        System.out.print(counter);
        while (counter > (Math.min(min, max)) - 1) {
            int currentNum = Math.max(min, max);
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            while (size(arrayList) <= size) {
                if (size(arrayList) == size) {
                    updateAnswer(s, arrayList);
                    arrayList.remove(arrayList.size() - 1);

                }
                arrayList.add(currentNum);
            }
            arrayList.remove(arrayList.size() - 1);
        }
    }

    public static int size(ArrayList<Integer> arrayList) {
        int size = 0;
        for (int a: arrayList) {
            size += a;
        }
        return size;
    }

    public static String updateAnswer(String s, ArrayList<Integer> integers) {
        for (int i: integers) {
            s += i + " ";
        }
        s = s.substring(0, s.length() - 1);
        s += "/n";
        return s;
    }
}