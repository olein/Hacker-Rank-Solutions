import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a;       
        
        int i = 0, j = 0;

        a = in.nextInt();
        int[][] b = new int[a][a];
        
        for (i = 0; i < a; i++) {
            for(j=0;j<a;j++) {
                b[i][j] = in.nextInt();
            }            
        }
        long sum = 0, sum2=0;
        for(i=0;i<a;i++) {
            sum = sum + b[i][i];
        }
        
        for(i=0;i<a;i++) {
            sum2 = sum2 + b[i][a-i-1];
        }
        System.out.println(Math.abs(sum-sum2));
    }
}