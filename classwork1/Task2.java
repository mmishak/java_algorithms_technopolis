package algorithms.classwork1;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mmishak on 04/10/16.
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try(PrintWriter pw = new PrintWriter(System.out)) {
            int n = s.nextInt();
            ArrayList<Long> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(s.nextLong());
            }

            n = s.nextInt();
            for (int i = 0; i < n; i++) {
                long tmp = s.nextLong();
                if (search(arr, tmp))
                    pw.println("YES");
                else
                    pw.println("NO");
            }
        }
    }

    public static boolean search(ArrayList<Long> arr, long key){
        int left = -1;
        int right = arr.size();
        while (left < right - 1){
            int mid = (left+right)/2;
            if (arr.get(mid) < key)
                left = mid;
            else
                right = mid;
        }

        if (Long.compare(right, arr.size()) == 0 || Long.compare(arr.get(right), key) != 0)
            return false;
        else
            return true;

    }
}
