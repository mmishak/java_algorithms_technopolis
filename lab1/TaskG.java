package algorithms.lab1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Веревочки (двоичный поиск)
 */
public class TaskG {
    public static void main(String[] args) {

        File fin = new File("src/algorithms/lab1/input.txt");
        File fout = new File("src/algorithms/lab1/output.txt");

        try{
            Scanner in = new Scanner(fin);
            PrintWriter out = new PrintWriter(fout);

            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];

            int max = in.nextInt();
            arr[0] = max;
            for (int i = 1; i < n; i++) {
                int tmp = in.nextInt();
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

            out.println(left);

            in.close();
            out.close();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
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
