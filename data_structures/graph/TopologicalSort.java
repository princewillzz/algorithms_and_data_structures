import java.io.*;
import java.util.ArrayList;

public class TopologicalSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter Vertices: ");
        String vertInp[] = br.readLine().split(" ");
        int v[] = new int[vertInp.length];
        for (int index = 0; index < vertInp.length; index++)
            v[index] = Integer.parseInt(vertInp[index]);

        ArrayList<int[]> edges = new ArrayList<>();
        for (int index = 0; index < vertInp.length; index++) {
            System.out.print("Enter Edges: ");
            String edgeInp[];
            try {
                edgeInp = br.readLine().trim().split(" ");
                int edge[] = new int[edgeInp.length];

                for (int edgeIndex = 0; edgeIndex < edgeInp.length; edgeIndex++) {
                    edge[edgeIndex] = Integer.parseInt(edgeInp[edgeIndex]);
                }
                edges.add(edge);
            } catch (Exception e) {
                edges.add(new int[] {});
            }

        }

        int ar[] = sort(v, edges);
        for (int i : ar)
            System.out.print(i + " ");

    }

    static int[] sort(int v[], ArrayList<int[]> edges) {
        int sorted[] = new int[v.length];
        boolean visited[] = new boolean[v.length];
        int index = v.length - 1;
        for (int i = 0; i < v.length; i++) {
            if (!visited[v[i]]) {
                index = search(v[i], v, edges, visited, sorted, index);
            }
        }

        return sorted;
    }

    static int search(int item, int v[], ArrayList<int[]> edges, boolean[] visited, int sorted[], int index) {

        System.out.println("\nVisiting: " + item);

        visited[item] = true;
        int edge[] = edges.get(item);
        for (int e : edge) {
            if (!visited[e]) {
                System.out.print("edges: " + e);
                index = search(e, v, edges, visited, sorted, index);
            }
        }
        sorted[index] = item;
        return index - 1;
    }
}
