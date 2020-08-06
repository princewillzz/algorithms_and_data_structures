import java.util.ArrayList;

public class Dijikstra{
    public static void main(String argv[]) {
        
        int vertex[] = new int[]{0, 1, 2, 3, 4};
        int edges[][] = new int[][]{{1, 2}, {3, 2}, {1, 3, 4}, {4}, {3}};
        int weights[][] = new int[][]{{10, 3}, {2, 1}, {4, 8, 2}, {7}, {9}};

        System.out.println("Distance: " + findShortestPath(vertex, edges, weights, 0));

    }
    static int value[] = new int[]{0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
    static int prev[] = new int[5];

    public static int findShortestPath(int[] vertex, int edges[][], int weights[][], int destination) {
        int ans = Integer.MAX_VALUE;

        visit(vertex[0], vertex, edges, weights);

        ans = value[destination];
        ArrayList<Integer> path = new ArrayList<>();
        while(destination != 0) {
            path.add(destination);
            destination = prev[destination];
        }
        path.add(0);

        for(int i = path.size()-1; i >= 0; i--) {
            System.out.print(path.get(i) + " -> ");
        }
        System.out.println();
        return ans;
    }

    public static void visit(int source, int[] vertex, int edges[][], int weights[][]) {

        int newSource = edges[source][0];
        boolean flag = false;
        for(int i = 0; i < edges[source].length; i++) {
            int d = weights[source][i] + value[source];
            int v = edges[source][i];
            // Relaxation process of edges
            if(d < value[v]) {
                flag = true;
                value[v] = d;
                prev[v] = source;
                
            }
            // Finding new Source
            if(value[v] <= newSource) {
                newSource = v;
            }
        }
        if(flag == false) return ;
        
        visit(newSource, vertex, edges, weights);
    }
}