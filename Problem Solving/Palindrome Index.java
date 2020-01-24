import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {
        if(isPelindrome(s)) return -1;
        
        int l = s.length();
        int q = l/2;
        for(int i=0;i<q;i++) {
                      
            if(isPelindrome(deleteCharAt(s, i))) return i;
            else if(isPelindrome(deleteCharAt(s, l-1-i))) return l-1-i;
        }
        return -1;
    }

    static String deleteCharAt(String strValue, int index) {
        return strValue.substring(0, index) + strValue.substring(index + 1);
    }

    static boolean isPelindrome(String p) {

        StringBuilder sb1 = new StringBuilder(p);   

        if(sb1.toString().equals(sb1.reverse().toString())) return true;

        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
