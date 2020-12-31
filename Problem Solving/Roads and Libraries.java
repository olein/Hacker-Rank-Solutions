import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n,int m, long c_lib, long c_road, int[][] cities) {
        
        if(c_lib<c_road) return (long)(c_lib *n);
        
        int[][] adj = new int[n+1][n+1];
        
        Arrays.stream(adj).forEach(a -> Arrays.fill(a, 0));
        
        for(int i=0;i<m;i++) {
            adj[cities[i][0]][cities[i][1]]=1;
            adj[cities[i][1]][cities[i][0]]=1;
        }
        
        long cost = 0l;
        boolean[] visited = new boolean[n+1];
        for(int i=1;i<=n;i++) {
            if(!visited[i]) {
                cost = cost + c_lib;
                visited[i] = true;
                for(int j=1;j<=n;j++) {
                    if(adj[i][j]==1) {
                        if(!visited[j]) {
                            cost = cost + c_road;
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        
        return cost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, m, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
