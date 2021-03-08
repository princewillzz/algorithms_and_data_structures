import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<List<Integer>> adjList;

    public Graph() {
        adjList = new ArrayList<>(12);
    }

    public void addEdge(int u, int v, boolean bidir) {
        addEdge(u, v);
        if (bidir) {
            addEdge(v, u);
        }
    }

    public void addEdge(int u, int v) {
        while (adjList.size() <= u) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(u).add(v);
    }

    public void printGraph() {

        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " --> ");
            for (int edge : adjList.get(i)) {
                System.out.print(edge + ", ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        final Graph graph = new Graph();
        graph.addEdge(0, 1, true);
        graph.addEdge(0, 2, true);
        graph.addEdge(0, 3, true);
        graph.addEdge(3, 2, true);
        graph.addEdge(1, 3, true);
        graph.addEdge(4, 3, true);

        graph.printGraph();
    }

}