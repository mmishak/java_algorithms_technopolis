package algorithms.seminar1;

import algorithms.seminar1.collections.LinkedStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) = 101
 * ( 1 + ( 5 * ( 4 * 5 ) ) ) ( 1 + ( 5 * 20 ) ) = 101
 * ( 1 + 100 ) = 101
 *
 * Считаем, что операции деления на ноль отсутствуют
 */
public class Solver {

    private static final String QUIT = "q";

    private static final char LEFT_PAREN   = '(';
    private static final char RIGHT_PAREN  = ')';
    private static final char PLUS         = '+';
    private static final char MINUS        = '-';
    private static final char TIMES        = '*';
    private static final char DIVISION     = '/';

    private static double evaluate(String[] values) {
        /* TODO: implement it */
        // Double.valueOf(values[i])
        LinkedStack<String> operands = new LinkedStack<>();
        LinkedStack<String> operations = new LinkedStack<>();

        for (int i = 1; i < values.length; i++) {
            if (isNumber(values[i])){
                operands.push(values[i]);
            }
            else if (isOperation(values[i])){
                operations.push(values[i]);
            }
            else if (values[i].charAt(0) == RIGHT_PAREN){
                operands.push(doOperation(operations.pop(), operands.pop(), operands.pop()));
            }
        }

        return Double.valueOf(operands.pop());
    }

    public static boolean isNumber(String str){
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                return false;
        }
        return true;
    }

    public static boolean isOperation(String str){
        if (str.length() == 1 && (
                str.charAt(0) == PLUS ||
                str.charAt(0) == MINUS ||
                str.charAt(0) == TIMES ||
                str.charAt(0) == DIVISION)){
            return true;
        }
        else return false;
    }

    public static String doOperation(String op, String second, String first){
        switch (op.charAt(0)){
            case PLUS:
                return Double.toString(Double.valueOf(first) + Double.valueOf(second));
            case MINUS:
                return Double.toString(Double.valueOf(first) - Double.valueOf(second));
            case TIMES:
                return Double.toString(Double.valueOf(first) * Double.valueOf(second));
            case DIVISION:
                return Double.toString(Double.valueOf(first) / Double.valueOf(second));
            default:
                System.out.println("Error in doOperation(): " + op.charAt(0));
                return "";
        }
    }

    public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                System.out.println(evaluate(sequence.split(" ")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
