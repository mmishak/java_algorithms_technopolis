package algorithms.classwork1;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mmishak on 04/10/16.
 */
public class Task3 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        try(PrintWriter pw = new PrintWriter(System.out)) {

            ArrayList<Long> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(s.nextLong());
            }

            n = s.nextInt();
            for (int i = 0; i < n; i++) {
                long tmp = s.nextLong();
                int indL = searchL(arr, tmp);
                int indR = searchR(arr, tmp);

                if (indL == -1)
                    pw.println(0);
                else if (indL == indR)
                    pw.println(1);
                else
                    pw.println(indR-indL+1);
            }

        }
    }

    public static int searchR(ArrayList<Long> arr, Long key){
        int left = -1;
        int right = arr.size();
        while (left < right - 1){
            int mid = (left+right)/2;
            if (arr.get(mid) <= key)
                left = mid;
            else
                right = mid;
        }

        if (Long.compare(left, -1) == 0 || Long.compare(arr.get(left), key) != 0)
            return -1;
        else
            return left;
    }

    public static int searchL(ArrayList<Long> arr, Long key){
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
            return -1;
        else
            return right;
    }
}
