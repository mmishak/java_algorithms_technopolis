package algorithms.classwork1;
import java.util.Scanner;

/**
 * Created by mmishak on 04/10/16.
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            double tmp = s.nextDouble();
            if (tmp < 30)
                count++;
        }

        int milk = count*200;
        if (milk % 900 != 0)
            milk = milk/900+1;
        else
            milk = milk/900;

        System.out.println(milk + " " + count);
    }

}
