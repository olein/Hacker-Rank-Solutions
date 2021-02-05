import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the triplets function below.
    static long triplets(Integer[] a, Integer[] b, Integer[] c) {
        
        Set<Integer> sa = new HashSet<Integer>(Arrays.asList(a));
        Set<Integer> sb = new HashSet<Integer>(Arrays.asList(b));
        Set<Integer> sc = new HashSet<Integer>(Arrays.asList(c));
        
        List<Integer> la = new ArrayList(sa);
        List<Integer> lc = new ArrayList(sc);
        Collections.sort(la);
        Collections.sort(lc);
        
        long count = 0;
        for(Integer i : sb) {
            long c1 = 0,c2=0;
            for(Integer j : lc) {
                if(j<=i) ++c2;
                else break;
            }
            for(Integer j : la) {
                if(j<=i) ++c1;
                else break;
            }
            count = count + (c1*c2);
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        Integer[] arra = new Integer[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        Integer[] arrb = new Integer[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        Integer[] arrc = new Integer[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
