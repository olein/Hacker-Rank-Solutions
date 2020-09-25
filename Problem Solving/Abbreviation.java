import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {

        int m = a.length(); 
        int n = b.length(); 
        String s = lcs(a.toUpperCase(), b, m, n);

        if((s.trim().equals(b.trim()))) {
            for(int i=0;i<a.length();i++) {
                if(Character.isUpperCase(a.charAt(i)) && s.indexOf(a.charAt(i))==-1)                     {
                    return "NO";
                } else if(Character.isUpperCase(a.charAt(i))){
                    s = charRemoveAt(s, s.indexOf(a.charAt(i)));
                }                
            }
            return "YES";
        }
        else {
            return "NO";
        }
    }

    public static String charRemoveAt(String str, int p) {  
        return str.substring(0, p) + str.substring(p + 1);  
    }  

    static String lcs(String X, String Y, int m, int n) 
    { 
        int[][] L = new int[m+1][n+1]; 
   
        // Following steps build L[m+1][n+1] in bottom up fashion. Note 
        // that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]  
        for (int i=0; i<=m; i++) 
        { 
            for (int j=0; j<=n; j++) 
            { 
                if (i == 0 || j == 0) 
                    L[i][j] = 0; 
                else if (X.charAt(i-1) == Y.charAt(j-1)) 
                    L[i][j] = L[i-1][j-1] + 1; 
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]); 
            } 
        } 
   
        // Following code is used to print LCS 
        int index = L[m][n]; 
        int temp = index; 
   
        // Create a character array to store the lcs string 
        char[] lcs = new char[index+1]; 
        lcs[index] = '\u0000'; // Set the terminating character 
   
        // Start from the right-most-bottom-most corner and 
        // one by one store characters in lcs[] 
        int i = m; 
        int j = n; 
        while (i > 0 && j > 0) 
        { 
            // If current character in X[] and Y are same, then 
            // current character is part of LCS 
            if (X.charAt(i-1) == Y.charAt(j-1)) 
            { 
                // Put current character in result 
                lcs[index-1] = X.charAt(i-1);  
                  
                // reduce values of i, j and index 
                i--;  
                j--;  
                index--;      
            } 
   
            // If not same, then find the larger of two and 
            // go in the direction of larger value 
            else if (L[i-1][j] > L[i][j-1]) 
                i--; 
            else
                j--; 
        } 
   
        // Print the lcs 
        
        String s = "";
        for(int k=0;k<=temp;k++) {            
            s = s + lcs[k];
        }
        return s.trim();
            
    } 

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
