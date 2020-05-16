import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import org.apache.commons.lang3.ArrayUtils;

public class ActivityNotifications{

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int c = 0, ind;      
        int[] arr = new int[d];
        int[] copyCount = new int[201];
        int size = expenditure.length;
        double mid;
        arr = subArray(expenditure, 0,d-1);
        int[] count = prepareArray(arr);
        
        for(int i=d;i<size;i++) { 
            copyCount = Arrays.copyOf(count,201);
            arr = countingSort(arr,copyCount);
            mid = getMedian(arr,d);
            //System.out.println("MID " + mid);
            if((double)expenditure[i]>=(mid*2)) ++c; 
            count = adjustArray(count,expenditure[i],expenditure[i-d]);

            ind = ArrayUtils.indexOf(arr, expenditure[i-d]);
            arr[ind] = expenditure[i];
        }
        return c;
    }
    
    static int[] prepareArray(int arr[]) {
        
        int n = arr.length;
        int count[] = new int[201];
        for (int i=0; i<=200; i++)
            count[i] = 0;
        
        for (int i=0; i<n; i++)
            ++count[arr[i]];
        //System.out.println("Arr size " + Arrays.toString(count));
        return count;
    }
    
    static int[] countingSort(int arr[], int[] count){
    
        int n = arr.length;
        int result[] = new int[n];
        for (int i=1; i<=200; i++)
            count[i] += count[i-1];
         
         for (int i = 0; i<n; i++)
         {
             result[count[arr[i]]-1] = arr[i];
             --count[arr[i]];
         }
         
         return result;
    }
    
    static int[] adjustArray(int[] count, int iv, int dv){  
        --count[dv];
        ++count[iv];        
        return count;
    }    
 


    public static double getMedian(int[] array, int d) {        
        if(d%2==1) return array[d/2];
        else return (double)(array[d/2] + array[d/2-1])/2;        
    }

    public static int[] subArray(int[] array, int beg, int end) {
        return Arrays.copyOfRange(array, beg, end + 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
