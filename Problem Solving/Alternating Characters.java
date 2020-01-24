import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int count = 0;       
        int i=0,j=1;
        while(s.length()>1 && j<s.length()) {
            try{                
                if(s.charAt(i) != s.charAt(j)) {
                    i = j;
                    j = j + 1;
                } else {
                    //s = deleteCharAt(s,i+1);
                    ++count;
                    ++j;
                }                
            } catch (Exception e) {

            }                
        }
        return count;
    }

    static String deleteCharAt(String strValue, int index) {       
        return strValue.substring(0, index) + strValue.substring(index + 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
