import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gridChallenge function below.
    static String gridChallenge(String[] grid) {
        int len = grid.length;
        
        char[] charArr = new char[grid[0].length()];
        for(int i=0;i<len;i++) {
            charArr = grid[i].toCharArray();
            Arrays.sort(charArr);
            grid[i] = new String(charArr);
        }
        
        int width = grid[0].length();
        
        charArr = new char[len];
        for(int i=0;i<width;i++) {
            for(int j=0;j<len;j++) {
                charArr[j] = grid[j].charAt(i);
                if(j>0 && charArr[j-1]>charArr[j]) return "NO";
            }            
        }
        
        
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] grid = new String[n];

            for (int i = 0; i < n; i++) {
                String gridItem = scanner.nextLine();
                grid[i] = gridItem;
            }

            String result = gridChallenge(grid);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
