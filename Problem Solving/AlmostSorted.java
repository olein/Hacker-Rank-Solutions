import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {

        int sort[] = arr.clone();
        Arrays.sort(sort); 
        int count = 0;
        int flag = 0;
        int index = 0;
        int start = -1;
        int end = -1;
  
        for(int i=0;i<arr.length;i++) {
            if(arr[i]!=sort[i] && flag == 0) {
                index = find(sort, arr[i]);
                
                if(arr[index]==sort[i]) {
                    ++count;
                    start = i+1;
                    flag = 1;
                }
                else {
                    System.out.println("no");
                    return;   
                }
            } else if(arr[i]!=sort[i] && flag == 1) {
                index = find(sort, arr[i]);
                if(arr[index]==sort[i]) {
                    ++count;
                    end = i+1;
                }
                else {
                    System.out.println("no");
                    return;   
                }
            }            
        }
        if(count==2)  {
            System.out.println("yes");
            System.out.println("swap " + start + " " + end);
        } else if(count>2) {
            System.out.println("yes");
            System.out.println("reverse " + start + " " + end);
        }
    }

    public static int find(int[] a, int target)
    {
        int index = Arrays.binarySearch(a, target);
        return (index < 0) ? -1 : index;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        almostSorted(arr);

        scanner.close();
    }
}
