package algorithms.seminar1;

import algorithms.seminar1.collections.LinkedStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. пустая строка — правильная скобочная последовательность;
 * 2. правильная скобочная последовательность,
 * взятая в скобки одного типа — правильная скобочная последовательность;
 * 3. правильная скобочная последовательность,
 * к которой приписана слева или справа правильная скобочная последовательность
 * — тоже правильная скобочная последовательность.
 */
public class ParenthesesSequenceExt {

    private static final String QUIT = "q";

    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char LEFT_BRACE = '{';
    private static final char RIGHT_BRACE = '}';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';

    // sequence = "()()" | "(({}[]))[[[" | "{}" | ...
    private static boolean isBalanced(String sequence) {
        LinkedStack<Character> stack = new LinkedStack<>();
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == LEFT_BRACE ||
                    sequence.charAt(i) == LEFT_BRACKET ||
                    sequence.charAt(i) == LEFT_PAREN) {
                stack.push(sequence.charAt(i));
            } else {
                if (sequence.charAt(i) == RIGHT_BRACE) {
                    if (stack.pop() != LEFT_BRACE)
                        return false;
                } else if (sequence.charAt(i) == RIGHT_BRACKET) {
                    if (stack.pop() != LEFT_BRACKET)
                        return false;
                } else if (sequence.charAt(i) == RIGHT_PAREN)
                    if (stack.pop() != LEFT_PAREN)
                        return false;
            }
        }

        if (stack.size() == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                System.out.println(isBalanced(sequence) ? "YES" : "NO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
