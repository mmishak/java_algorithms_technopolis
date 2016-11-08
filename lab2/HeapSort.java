package algorithms.lab2;
import java.util.Scanner;

/**
 * Created by mmishak on 07/11/16.
 */
public class HeapSort {
    private static int[] heap;
    private static int heapSize;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        heapSize = str.length;
        heap = new int[heapSize];
        for (int i = 0; i < heap.length; i++) {
            heap[i] = Integer.parseInt(str[i]);
        }
        heapSort();
        printArray();
    }

    private static void heapSort() {
        build();
        for (int i = 0; i < heap.length - 1; i++) {
            swap(0, heap.length - 1 - i);
            heapSize--;
            siftDown(0);
        }
    }

    private static void build() {
        for (int i = heap.length / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

    private static void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private static void siftDown(int i) {
        while (2 * i + 1 < heapSize) {
            int left = 2 * i + 1,
                    right = 2 * i + 2;
            int j = left;
            if (right < heapSize && heap[right] > heap[left])
                j = right;
            if (heap[i] > heap[j])
                break;
            swap(i, j);
            i = j;
        }
    }

    private static void printArray() {
        for (int anArr : heap) {
            System.out.print(anArr + " ");
        }
        System.out.println();
    }
}