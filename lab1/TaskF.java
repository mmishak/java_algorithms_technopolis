package algorithms.lab1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Мутанты (двоичный поиск)
 */
public class TaskF {
    public static void main(String[] args) {

        File fin = new File("src/algorithms/lab1/input.txt");
        File fout = new File("src/algorithms/lab1/output.txt");

        try{
            Scanner in = new Scanner(fin);
            PrintWriter out = new PrintWriter(fout);

            int n = in.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }

            int m = in.nextInt();
            for (int i = 0; i < m; i++) {
                long tmp = in.nextLong();
                int indL = searchL(arr, tmp);
                int indR = searchR(arr, tmp);

                if (indL == -1)
                    out.println(0);
                else if (indL == indR)
                    out.println(1);
                else
                    out.println(indR-indL+1);
            }

            in.close();
            out.close();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static int searchR(long[] arr, Long key){
        int left = -1;
        int right = arr.length;
        while (left < right - 1){
            int mid = (left+right)/2;
            if (arr[mid] <= key)
                left = mid;
            else
                right = mid;
        }

        if (Long.compare(left, -1) == 0 || Long.compare(arr[left], key) != 0)
            return -1;
        else
            return left;
    }

    public static int searchL(long[] arr, Long key){
        int left = -1;
        int right = arr.length;
        while (left < right - 1){
            int mid = (left+right)/2;
            if (arr[mid] < key)
                left = mid;
            else
                right = mid;
        }

        if (Long.compare(right, arr.length) == 0 || Long.compare(arr[right], key) != 0)
            return -1;
        else
            return right;
    }
}
