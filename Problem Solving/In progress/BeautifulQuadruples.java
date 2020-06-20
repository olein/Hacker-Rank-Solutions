import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the beautifulQuadruples function below.
     */
    static long beautifulQuadruples(int a, int b, int c, int d) {
        /*
         * Write your code here.
         */
         List<Integer> v = new ArrayList();
         List<Integer> v2 = new ArrayList();
         List<Integer> v3 = new ArrayList();
         v.add(a);
         v.add(b);
         v.add(c);
         v.add(d);

         Collections.sort(v);
         long count = 0;        


        for(short i=1;i<=v.get(0);i++) {
            for(short j=i;j<=v.get(1);j++) {
            int s = (i^j);
                for(short k=j;k<=v.get(2);k++) {
                    for(short l=k;l<=v.get(3);l++) {                       
                        if(i==j && k==l) continue;
                        if(s!=(k^l)) {
                            ++count;
                            //System.out.println(i + " " + j + " " + k + " " + l);
                        }                        
                    }
                }
            }
        }        
        
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] abcd = scanner.nextLine().split(" ");

        int a = Integer.parseInt(abcd[0].trim());

        int b = Integer.parseInt(abcd[1].trim());

        int c = Integer.parseInt(abcd[2].trim());

        int d = Integer.parseInt(abcd[3].trim());

        long result = beautifulQuadruples(a, b, c, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
