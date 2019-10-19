package Impact_Factor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class v1 {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int numStrings = in.nextInt();
        ArrayList<String> data = new ArrayList<>();
        in.nextLine();
        for(int i = 0; i < numStrings; i++) {
            data.add(in.nextLine());
        }

        for (String s:data) {
            System.out.println(s);
        }
    }
}
