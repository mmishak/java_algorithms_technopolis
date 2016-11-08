package algorithms.lab1;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Мега НОД
 */
public class TaskC {
    public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);

            String[] n = in.nextLine().split(" ");
            int nod = Integer.valueOf(n[0]);

            for (int i = 1; i < n.length; i++) {
                nod = getNOD(nod, Integer.valueOf(n[i]));
            }

            out.println(nod);

            in.close();
            out.close();

    }

    public static int getNOD(int a, int b){
        while (a != b) {
            if (a > b)
                a -= b;
            else
                b -= a;
        }
        return a;

    }
}
