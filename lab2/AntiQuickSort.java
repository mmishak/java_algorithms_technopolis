package algorithms.lab2;

import java.util.Scanner;

/**
 * Created by mmishak on 14/11/16.
 */
public class AntiQuickSort {

    public static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i-1] = i;
        }

        for (int i=2;i<n;i++)
            swap(i, i/2);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
