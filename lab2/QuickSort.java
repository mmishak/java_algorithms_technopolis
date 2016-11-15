package algorithms.lab2;

import java.util.Scanner;

/**
 * Created by mmishak on 10/11/16.
 */
public class QuickSort {

    public static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split(" ");
        arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        quicksort(0, arr.length-1);

        printarray();
    }

    public static void quicksort(int left, int right) {

        int m = arr[(left+right) / 2];
        int i = left;
        int j = right;

        do {
            while (arr[i] < m)
                i++;
            while (arr[j] > m)
                j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        } while (i < j);

        if (j > left)
            quicksort(left, j);
        if (i < right)
            quicksort(i, right);
    }


    public static void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printarray(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
