package algorithms.lab1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Структура Heap
 */
public class TaskK {

    public static class Heap {
        private int[] arr;
        private int heapSize = 0;

        public Heap() {
            arr = new int[10];
        }
        public Heap(int size) {
            arr = new int[size];
        }

        public void insert(int x) {
            heapSize++;
            arr[heapSize-1] = x;
            siftUp(heapSize-1);
        }

        public int extract() {
            int max = arr[0];
            arr[0] = arr[heapSize-1];
            heapSize--;
            siftDown(0);
            return max;
        }

        private void siftUp(int i) {
            while (arr[i] > arr[(i - 1) / 2]) {
                swap(i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }

        private void siftDown(int i) {
            while (2 * i + 1 < heapSize) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int j = left;
                if (right < heapSize && arr[right] > arr[left]) {
                    j = right;
                }
                if (arr[i] > arr[j]) {
                    break;
                }
                swap(i, j);
                i = j;
            }
        }

        private void swap(int x, int y) {
            int tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }
    }

    public static void main(String[] args) {


            Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);

            int n = Integer.valueOf(in.nextLine());

            Heap heap = new Heap(n);
            for (int i = 0; i < n; i++) {

                String[] command = in.nextLine().split(" ");

                if (command[0].equals("0")) {
                    heap.insert(Integer.valueOf(command[1]));
                }
                else {
                    out.println(heap.extract());
                }
            }

            in.close();
            out.close();

    }
}
