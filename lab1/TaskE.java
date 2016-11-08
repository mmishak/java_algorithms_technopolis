package algorithms.lab1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Столбцы
 */
public class TaskE {
    public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);

            long x = in.nextLong();
            int n = in.nextInt();

            boolean[] arr = new boolean[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (Long.compare(x, in.nextLong()) == 0)
                        arr[j] = true;
                }
            }

            for (int i = 0; i < n; i++) {
                out.println(arr[i] ? "YES" : "NO");
            }

            in.close();
            out.close();

    }
}
