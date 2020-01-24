import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int birthdayCakeCandles(int n, int[] ar) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < ar.length; i++) {
            list.add(ar[i]);
        }
        Collections.sort(list);
        
        int value = (int) list.get(list.size()-1);
        
        int count = 1;
        for(int i = list.size()-2; i>=0; i--) {
           if(value==(int)list.get(i)) ++count;
           else break;
        }       
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
