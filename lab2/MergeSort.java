package algorithms.lab2;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by mmishak on 08/11/16.
 */
public class MergeSort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.valueOf(sc.nextLine());

        int[] first = new int[n];
        int[] second = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            first[i] = Integer.valueOf(input[0]);
            second[i] = Integer.valueOf(input[1]);
        }

        for (int len = 1; len < n; len *= 2)
            for (int left = 0; left < n - len; left += len + len)
                merge(first, second, left, left + len, Math.min(left + len + len, n));

        for (int i = 0; i < n; i++) {
            pw.println(first[i] + " " + second[i]);
        }

        pw.close();

    }

    public static void merge(int[] a1, int[] a2, int left, int mid, int right) {

        int it1 = 0;
        int it2 = 0;

        int[] res1 = new int[right-left];
        int[] res2 = new int[right-left];

        while (left + it1 < mid && mid + it2 < right) {

            if (a1[left + it1] <= a1[mid + it2]) {

                res1[it1 + it2] = a1[left+it1];
                res2[it1 + it2] = a2[left+it1];
                it1 += 1;

            } else {

                res1[it1 + it2] = a1[mid + it2];
                res2[it1 + it2] = a2[mid + it2];
                it2 += 1;
            }
        }

        while (left + it1 < mid) {
            res1[it1 + it2] = a1[left + it1];
            res2[it1 + it2] = a2[left + it1];
            it1 += 1;
        }

        while (mid + it2 < right) {
            res1[it1 + it2] = a1[mid + it2];
            res2[it1 + it2] = a2[mid + it2];
            it2 += 1;
        }

        for (int i = 0; i < it1 + it2; i++) {
            a1[left + i] = res1[i];
            a2[left + i] = res2[i];
        }
    }

}
