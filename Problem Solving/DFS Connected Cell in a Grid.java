import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class Point {
        public int x=0;
        public int y=0;
        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }
    // Complete the maxRegion function below.
    static int maxRegion(int n, int m, int[][] grid) {

        Stack<Point> stack = new Stack();
        //stack.add(new Point(0,0));
        int max = 0;
        int count = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {  
                if(grid[i][j]==1) {
                    stack.add(new Point(i,j));
                    count = 0;
                    int q = i;
                    int r = j;
                    while(!stack.empty()) {
                        Point p = stack.pop();    
                        if(grid[p.x][p.y]==1){
                            ++count;
                        }
                        i = p.x;
                        j= p.y;
                        
                        grid[p.x][p.y]=0;
                        if(i-1>=0 && j-1>=0 && grid[i-1][j-1]==1) 
                            stack.add(new Point(i-1, j-1));
                        if(i-1>=0 && j>=0 && grid[i-1][j]==1) 
                            stack.add(new Point(i-1, j));
                        if(i-1>=0 && j+1<m && grid[i-1][j+1]==1) 
                            stack.add(new Point(i-1, j+1));
                        if(i>=0 && j-1>=0 && grid[i][j-1]==1) 
                            stack.add(new Point(i, j-1));
                        if(i>=0 && j+1<m && grid[i][j+1]==1) 
                            stack.add(new Point(i, j+1));
                        if(i+1<n && j-1>=0 && grid[i+1][j-1]==1) 
                            stack.add(new Point(i+1, j-1));
                        if(i+1<n && j>=0 && grid[i+1][j]==1) 
                            stack.add(new Point(i+1, j));
                        if(i+1<n && j+1<m && grid[i+1][j+1]==1) {
                            stack.add(new Point(i+1, j+1));
                        }                            
                    }
                    max = max<count?count:max;
                    i = q;
                    j = r;
                }
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(n, m, grid);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
