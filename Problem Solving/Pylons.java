import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Pylons {

    // Complete the pylons function below.
    static int pylons(int n, int k, int[] arr) {
        int count = 0;
        int size = 0;
        int len = k-1;  

        int[] h = new int[arr.length];
        System.arraycopy(arr, 0, h, 0, h.length);   

        for(int i=0;i<n;i++) {
            if(h[i]==1) {
                for(int j=1;j<=len;j++) {
                    if(i-j>=0 && h[i-j]==0) h[i-j]=2;
                }
                for(int j=1;j<=len;j++) {
                    if(i+j<n && h[i+j]==0) h[i+j]=2;
                }
                //i=i+len-1;
            }
        }
        //System.out.println(Arrays.toString(h));
        
        for(int i=0;i<n;i++) {
            if(h[i]==0) return -1;
        }        
        int i = 0;
        while(i<n) {
            int tag = 0;
            if(arr[i]==0) {                
                for(int j=len;j>=0;j--) {
                    if(i+j<n && arr[i+j]==1) {
                        System.out.println((i+j) +" "+arr[i+j]);
                        i = i+j+len+1;    
                        tag = 1;                                             
                        break; 
                    }               
                }
                if(tag==0) i = i + len;
                ++size;  
                          
                if(i>=n) return size;
                System.out.println(i +" "+size+" "+arr[i]);
            } else {
                for(int j=len;j>0;j--) {
                    if(i+j<n && arr[i+j]==1) { 
                        System.out.println((i+j) +" "+arr[i+j]);                    
                        i = i+j+len+1; 
                        tag = 1;   
                        break;
                    }                     
                }
                if(tag==0) i = i + len + 1;
                ++size;    
                if(i>=n) return size;
                System.out.println(i +" "+size+" "+arr[i]);
            }       
        }
        return size;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pylons(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
