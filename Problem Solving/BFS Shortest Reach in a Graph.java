import java.io.*;
import java.util.*;

public class Solution {
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        
        while(q>0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] dist = new int[n+1];
            int[][] adj = new int[n+1][n+1];
            Arrays.fill(dist, -1);            
            
            while(m>0) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                
                adj[a][b] = 1;
                adj[b][a] = 1;
                --m;
            }
            int c = scanner.nextInt();
            int seed = c;
            dist[seed] = 0;
            
            int length = 0;
            
            boolean[] visited = new boolean[n+1];
            
            Queue<Integer> queue = new LinkedList<>(); 
            queue.add(c); 
            
            while(queue.size()>0) {
                c = queue.remove();
                int flag = 0;
                visited[c] = true;
                for(int i=1;i<=n;i++) {                    
                    if(adj[c][i]==1 && !visited[i]) {
                        if(flag == 0) {
                            ++length;
                            flag = 1; 
                        }
                        if(dist[i]==-1) dist[i] = dist[c]+6;     
                        queue.add(i);
                    }
                }
            }
            for(int j=1;j<=n;j++) {
                if(j!=seed)System.out.print(dist[j]+" "); 
            }
            System.out.print("\n");          
            --q;            
        }
        
    }
}