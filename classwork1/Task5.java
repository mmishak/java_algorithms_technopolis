package algorithms.classwork1;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by mmishak on 05/10/16.
 */
public class Task5 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        long w = s.nextLong();
        long h = s.nextLong();
        long n = s.nextLong();

        long left = 0;
        long right = n*Math.max(w,h);

        while (left < right) {
            long tmp = (left + right) / 2;
            long num = (tmp / w) * (tmp / h);

            if (num >= n)
                right = tmp;
            else
                left = tmp + 1;
        }

        try (PrintWriter pw = new PrintWriter(System.out)) {
            pw.println(left);
        }
    }
}
