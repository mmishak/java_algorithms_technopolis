package algorithms.lab1;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Ревизия (двойной минимум)
 */
public class TaskD {
    public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);

            int n = in.nextInt();
            long min1, min2;

            min1 = in.nextLong();
            min2 = in.nextLong();

            if (min1 > min2){
                long tmp = min1;
                min1 = min2;
                min2 = tmp;
            }

            for (int i = 2; i < n; i++) {
                long tmp = in.nextLong();
                if (tmp < min2)
                    if (tmp < min1){
                        min2 = min1;
                        min1 = tmp;
                    }
                    else
                        min2 = tmp;
            }

            out.println(min1 + " " + min2);

            in.close();
            out.close();

    }
}
