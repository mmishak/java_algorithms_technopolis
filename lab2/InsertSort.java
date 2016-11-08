package algorithms.lab2;

import java.util.Scanner;

/**
 * Created by mmishak on 07/11/16.
 */
public class InsertSort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            boolean flag = false;

            int j;
            for (j = i - 1; j >= 0 && arr[j] > x; j--) {
                arr[j + 1] = arr[j];
                flag = true;
            }

            arr[j + 1] = x;

            if (flag)
                printArray(arr);
        }


    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
