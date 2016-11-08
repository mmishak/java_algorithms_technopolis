package algorithms.lab2;

import java.util.Scanner;

/**
 * Created by mmishak on 07/11/16.
 */
public class SelectSort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int pointer = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int k = i;
            int x = arr[i];

            for (int j = i + 1; j < n; j++)
                if (arr[j] < x) {
                    k = j;
                    x = arr[j];
                }

            if ( Integer.compare(k, i) != 0 && Integer.compare(pointer, i) == 0 ) {

                count++;
                pointer = k;

            } else if ( Integer.compare(k, i) != 0 && Integer.compare(pointer, k) == 0 ) {

                count++;
                pointer = i;
            }

            arr[k] = arr[i];
            arr[i] = x;
        }

        System.out.println(count);
    }
}
