import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for (int arr_i = 0; arr_i < 5; arr_i++) {
            arr[arr_i] = in.nextInt();
        }

        ArrayList list = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        
        Collections.sort(list);
        
        long min = 0;
        for (int i = 0; i < 4; i++) {
            min = min + (int) list.get(i);
        }
        
        long max = 0;
        for (int i = 1; i < 5; i++) {
            max = max + (int) list.get(i);
        }
        
        
        System.out.println(min + " " + max);
    }
}
