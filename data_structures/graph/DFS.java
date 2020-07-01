import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS{
    public static void main(String argv[]) throws IOException {
        
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{1, 2});
        edges.add(new int[]{3, 4});
        edges.add(new int[]{5, 6});
        edges.add(new int[]{0});
        edges.add(new int[]{0, 0});
        edges.add(new int[]{0,0});
        edges.add(new int[]{0});
        byte[] visited = new byte[edges.size()+1];
        dfs(0, edges, visited);
    }
    static void dfs(int start, List<int[]> edges, byte[] visited) {
        int[] edge = edges.get(start);
        System.out.println(start);
        visited[start] = 1;
        for(int i = 0; i < edge.length; i++) {
            if(visited[edge[i]] == 1) continue;
            
            visited[edge[i]] = 1;

            dfs(edge[i], edges, visited);

        }


    } 

}