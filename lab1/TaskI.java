package algorithms.lab1;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Очередь
 */
public class TaskI {

    public static class Queue {
        private String[] arr;
        private int size;
        private int beginPointer;
        private int endPointer;

        public Queue() {
            arr = new String[100];
        }

        public String push(String x) {
            checkEnd();
            arr[endPointer++] = x;
            size++;
            return "ok";
        }

        public String pop() {
            size--;
            return arr[beginPointer++];
        }

        public String front() {
            return arr[beginPointer];
        }

        public int size() {
            return size;
        }

        public String clear() {
            beginPointer = 0;
            endPointer = 0;
            size = 0;
            return "ok";
        }

        public void checkEnd() {
            if (endPointer == arr.length) {
                int count = beginPointer;
                for (int i = 0; i < size; i++) {
                    arr[i] = arr[count++];
                }
                beginPointer = 0;
                endPointer = beginPointer + size;
            }
        }

    }

    public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);

            Queue queue = new Queue();

            for (;;) {
                String[] command = in.nextLine().split(" ");

                if (command[0].equals("push")){
                    System.out.println(queue.push(command[1]));
                }
                else if (command[0].equals("pop")){
                    System.out.println(queue.pop());
                }
                else if (command[0].equals("front")){
                    System.out.println(queue.front());
                }
                else if (command[0].equals("size")){
                    System.out.println(queue.size());
                }
                else if (command[0].equals("clear")){
                    System.out.println(queue.clear());
                }
                else if (command[0].equals("exit")){
                    System.out.println("bye");
                    break;
                }
            }

            in.close();
            out.close();

    }
}
