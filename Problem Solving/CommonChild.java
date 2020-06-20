import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        char[] X = s1.toCharArray(); 
        char[] Y = s2.toCharArray(); 
        int m = X.length; 
        int n = Y.length; 
  
        return lcs(X, Y, m, n); 
    }

    static int lcs(char[] X, char[] Y, int m, int n) { 
        int L[][] = new int[m + 1][n + 1]; 

        for (int i = 0; i <= m; i++) { 
            for (int j = 0; j <= n; j++) { 
                if (i == 0 || j == 0) 
                    L[i][j] = 0; 
                else if (X[i - 1] == Y[j - 1]) 
                    L[i][j] = L[i - 1][j - 1] + 1; 
                else
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]); 
            } 
        } 
         
        return L[m][n]; 
    } 

    static int max(int a, int b) 
    { 
        return (a > b) ? a : b; 
    } 

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
