import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.LinkedList; 
import java.util.Queue; 

public class Solution {

    static class  Node { 
        public int x;
        public int y;
        public Node(int a, int b) {
            x = a;
            y = b;
        }       
    } 

    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix,int m, int n) {
        int count = 0,max=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(max<count) max = count;
                count = 0;
                if(matrix[i][j]==1) {                    
                    Queue<Node> q = new LinkedList<>(); 
                    q.add(new Node(i,j));
                    //System.out.println(i + " " + j);
                    while(q.size()>0) {
                        Node current = q.remove(); 
                        //System.out.println(current.x + " " + current.y);
                        //System.out.println(q.size());
                        if(matrix[current.x][current.y]==1) {
                            q = findAdjacent(current, q, matrix, m, n);
                            ++count;
                            System.out.println(q.size());
                            matrix[current.x][current.y]=0;
                        }                        
                    }
                }
            }
        }
        return max;
    }

    public static Queue<Node> findAdjacent(Node current, Queue<Node> q, int[][] matrix,
                                    int m, int n) {

        if(current.x-1>=0) {
            if(current.y-1>=0) {
                if(matrix[current.x-1][current.y-1]==1) {
                    q.add(new Node(current.x-1,current.y-1));                    
                    //return q;
                }
            }

            if(matrix[current.x-1][current.y]==1) {
                q.add(new Node(current.x-1,current.y));
                //return q;
            }        

            if(current.y+1<m) {
                if(matrix[current.x-1][current.y+1]==1) {
                    q.add(new Node(current.x-1,current.y+1));
                    //return q;
                }
            }
        }
        

        if(current.y-1>=0) {
            if(matrix[current.x][current.y-1]==1) { 
                q.add(new Node(current.x,current.y-1));
                //return q;
            }
        }

        if(current.y+1<m) {
            if(matrix[current.x][current.y+1]==1) {
                q.add(new Node(current.x,current.y+1));
                //return q;
            }
        }

        if(current.x+1<n) {
            if(current.y-1>=0) {
                if(matrix[current.x+1][current.y-1]==1) {
                    q.add(new Node(current.x+1,current.y-1));
                    //return q;
                }
            }

            if(matrix[current.x+1][current.y]==1) {
                q.add(new Node(current.x+1,current.y));
                //return q;
            }

            if(current.y+1<m) {
                if(matrix[current.x+1][current.y+1]==1) {
                    q.add(new Node(current.x+1,current.y+1));
                    //return q;
                }
            }
        }       
        
        return q;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix,m,n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
