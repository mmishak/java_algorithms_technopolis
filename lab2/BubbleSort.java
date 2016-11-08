package algorithms.lab2;

import java.util.Scanner;

/**
 * Created by mmishak on 07/11/16.
 */
public class BubbleSort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (arr[i] > arr[j]) {
//                    int tmp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = tmp;
//
//                    count++;
//                }
//            }
//        }

        for (int i = 0; i < n; i++) {
            for (int j = n-1; j > i; j--) {
                if (arr[j-1] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;

                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
