package algorithms.classwork1;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by mmishak on 05/10/16.
 */
public class Task4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] arr = new int[n];

        int max = s.nextInt();
        arr[0] = max;
        for (int i = 1; i < n; i++) {
            int tmp = s.nextInt();
            if (tmp > max)
                max = tmp;
            arr[i] = tmp;
        }

        int left = 0;
        int right = max+1;

        while (left < right - 1){
            int mid = (left+right)/2;
            if ( count(arr,mid) < k )
                right = mid;
            else
                left = mid;
        }

        try (PrintWriter pw = new PrintWriter(System.out)) {
            pw.println(left);
        }
    }

    public static int count(int[] arr, int key){
        int sum = 0;
        for (int i = 0; i< arr.length; i++) {
            sum += arr[i] / key;
        }
        return sum;
    }
}
