import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        Map<Integer, List<Integer>> val = new HashMap();
        
        for(int i=0;i<cost.length;i++) {
            if(val.containsKey(cost[i])) {
                List<Integer> list = val.get(cost[i]);
                list.add(i);
                val.put(cost[i], list);
            } else {
                List<Integer> list = new ArrayList();
                list.add(i);
                val.put(cost[i],list);
            }
        }
        
        for(Integer key : cost) {
            if(money-key>0) {
                int diff = money - key;
                if(val.get(key)!=null && diff == key) {
                    List<Integer> list = val.get(key);
                    if(list.size()>=2) {
                        System.out.println((list.get(0)+1) +" "+(list.get(1)+1));
                        return;
                    }                    
                } else if(val.get(diff)!=null ) {
                    System.out.println((val.get(key).get(0)+1) +" "+(val.get(diff).get(0)+1));
                    return;
                }
            }
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
