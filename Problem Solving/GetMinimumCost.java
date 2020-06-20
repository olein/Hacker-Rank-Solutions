import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GetMinimumCost{

    // Complete the getMinimumCost function below.
    static Integer getMinimumCost(int n, int k, Integer[] c) {
        int count = 0;
        int size = 0;
        Integer cost = 0;

        if(n%k==0) size = n/k;
        else size = (n/k) + 1;
         
        List<Integer> list = new ArrayList<>(Arrays.asList(c));
        Collections.sort(list, Collections. reverseOrder());

        for(int i=1;i<=size;i++) {
            for(int j=0;j<k;j++) {
                if(list.size()>0) {
                    cost = cost + (i*list.get(0));
                    list.remove(0);
                } else break;                
            }
        }
        return cost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        Integer[] c = new Integer[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(n, k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
