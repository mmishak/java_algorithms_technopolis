package algorithms.lab1;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Проверка на простоту
 */
public class TaskB {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        out.println(checkSimple(in.nextInt()));

        in.close();
        out.close();

    }

    public static String checkSimple(int n){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return "False";
        }
        return "True";
    }
}
