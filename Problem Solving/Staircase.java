import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a;

        int i = 0, j = 0;
        
        a = in.nextInt();        

        for (i = 0; i < a; i++) {
            for(j=0;j<a-i-1;j++) {
               System.out.print(" "); 
            }
            for(j=0;j<i+1;j++){
                System.out.print("#");
            }  
            System.out.print("\n");
        }  
    }
}