import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[3];
        int[] b = new int[3];
        int i=0,j=0,k=0;
        for(i=0;i<3;i++) {
            a[i] = in.nextInt();
        }
        for(i=0;i<3;i++) {
            b[i] = in.nextInt();
        }
        for(i=0;i<3;i++) {
            if(a[i] > b[i]) {
                ++j;
            } else if(a[i] < b[i]) {
                ++k;
            }
            
        }        
        System.out.println(j+" "+k);
    }
}
