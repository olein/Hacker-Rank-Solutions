import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AbsolutePermutation {

    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {
        int v = 0;
        int[] res = new int[n];
        if(k==0) {
            for(int i=1;i<=n;i++) res[i-1] = i;
            return res;
        }
        if(k>n/2) return new int[] {-1};
        Set<Integer> val = new HashSet();
        int s = n/(2*k);
        int count = 0;
        for(int i=0;i<=s;i++) {
            for(int j=1; j<=k;j++) {
                if(count==n) return res;
                v = (i*2*k) + (j+k);
                if(v>n) v = v%n;
                if(val.contains(v))  return new int[] {-1};
                else res[count++] = v;
                val.add(v);
            } 
            for(int j=k+1;j<=2*k;j++) {
                if(count==n) return res;
                v = (i*2*k) + Math.abs(j-k);
                if(v>n) v = v%n;
                if(val.contains(v))  return new int[] {-1};
                else res[count++] = v;
                val.add(v);
            }
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] result = absolutePermutation(n, k);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
