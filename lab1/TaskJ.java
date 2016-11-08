import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class TaskJ {
    public static void main(String[] args) {

        // File fin = new File("src/algorithms/lab1/input.txt");
        // File fout = new File("src/algorithms/lab1/output.txt");

//        try{
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//            Scanner in = new Scanner(fin);
//            PrintWriter out = new PrintWriter(fout);

        int n = in.nextInt();
        long[] heap = new long[n];
        for (int i = 0; i < n; i++) {
            heap[i] = in.nextLong();
        }

        out.println(isHeap(heap) ? "YES" : "NO");

        in.close();
        out.close();

//        } catch (IOException ex){
//            System.out.println(ex.getMessage());
//        }
    }

    public static boolean isHeap(long[] heap){
        for (int i = 0; i < heap.length; i++) {
            if (2*i+1 <= heap.length-1 && heap[i] > heap[2*i+1] || 2*i+2 <= heap.length-1 && heap[i] > heap[2*i+2])
                return false;
        }
        return true;
    }
}