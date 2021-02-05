import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the poisonousPlants function below.
    static int poisonousPlants(int[] p) {
        List<Integer> arr
            = new ArrayList<Integer>();
            
        for(int i=0;i<p.length;i++) {
            arr.add(p[i]);
        }
        
        int count = 0;
        while(arr.size()>0) {
            List<Integer> rem = new ArrayList();
            
            for(int i=1;i<arr.size();i++) {
                if(arr.get(i-1)<arr.get(i)) {
                    rem.add(i);
                }
            }
            System.out.println("Rem " + rem.size());
            if(rem.size()>0) {
                for(int i=0;i<rem.size();i++) {
                    arr.remove(rem.get(i)-i);
                }
                ++count;
            } else break;
        }
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int result = poisonousPlants(p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
