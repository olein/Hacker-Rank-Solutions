import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import org.apache.commons.lang3.StringUtils;

public class WeightedUniformStrings{

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        String[] res = new String[queries.length];
        List<Integer> values = new ArrayList();
        char prevChar = 'A';
        int prevVal = 0;
        int val = 0;
        char c;
        for(int i=0;i<s.length();i++) {
            c = s.charAt(i);
            if(c==prevChar) {
                val = prevVal + ((int) c - 96);
                prevVal = val;
                prevChar = c;
                values.add(val);
            } else {
                val = 0;
                prevChar = c;
                prevVal = (int) c - 96;
                val = prevVal;
                values.add(prevVal);
            }
        }
        
        Collections.sort( values );
        for(int i=0;i<queries.length;i++) {
            if(Collections.binarySearch(values, queries[i])>=0) res[i] = "Yes";
            else res[i] = "No";
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
