package algorithms.lab1;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Постфиксная запись (стек)
 */
public class TaskH {
    public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);

            long[] stack = new long[100];
            String[] inStream = in.nextLine().split(" ");
            int pointer = -1;

            for (int i = 0; i < inStream.length; i++) {
                if ( isNumber(inStream[i]) ){

                    stack[++pointer] = Integer.valueOf(inStream[i]);

                } else if ( inStream[i].equals("*") ){

                    long a = stack[pointer--];
                    long b = stack[pointer--];
                    stack[++pointer] = a*b;

                } else if ( inStream[i].equals("+") ){

                    long a = stack[pointer--];
                    long b = stack[pointer--];
                    stack[++pointer] = a+b;

                } else if (inStream[i].equals("-")) {

                    long a = stack[pointer--];
                    long b = stack[pointer--];
                    stack[++pointer] = b-a;

                }
            }

            out.println(stack[pointer]);

            in.close();
            out.close();

    }

    public static boolean isNumber(String s){
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }
}
