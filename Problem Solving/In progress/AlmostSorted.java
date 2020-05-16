import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AlmostSorted {

    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {

        int size = arr.length;
        int ti=0,t=0,d=0;
        boolean done = false;
        String res = "";

        for(int i=0;i<size-1;i++) {
            if(arr[i]>arr[i+1]) {
                t = arr[i];
                ti = i+1;
                //System.out.println("TI " + ti);
                for(int j = i;j<size-1;j++) {
                    if(arr[j]<arr[j+1] && t < arr[j+1]) {
                        if(done) {
                            res = "no";
                            i=size;
                            break;
                        }
                        d = j+1 - ti;
                        if(d>1) res = "reverse " + ti + " " + (j+1);
                        else res = "swap " + ti + " " + (j+1);
                        i = j + 1;
                        done = true;
                        break;
                    } else if (arr[j]<arr[j+1] && t > arr[j+1]) {
                        res = "no";
                        break;
                    } else {
                        if(done) {
                            res = "no";
                            i=size;
                            break;
                        }
                        d = j+1 - ti;
                        if(d>1) res = "reverse " + ti + " " + (size);
                        else res = "swap " + ti + " " + (size);
                        i = j + 1;
                        done = true;
                        break;
                    }
                }
                if(!done) res = "swap " + ti + " " + (size);
            }
        }

        if(res.equals("no")) System.out.println(res);
        else {
            System.out.println("yes");
            System.out.println(res);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        almostSorted(arr);

        scanner.close();
    }
}
