package algorithms.lab1;

import java.io.*;
import java.util.Scanner;

/**
 * A + B
 */
public class TaskA {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            out.println(in.nextInt() + in.nextInt());
        }

        in.close();
        out.close();

    }
}
