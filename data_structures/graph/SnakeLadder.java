import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SnakeLadder {

    private List<List<Integer>> adjList;

    SnakeLadder() {
        adjList = new ArrayList<>();
        while (adjList.size() <= 100) {
            adjList.add(new ArrayList<>());
        }

    }

    public void addEdge(int u, int v) {

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

    void bfsDistance(int src, int dest) {

        LinkedList<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[adjList.size() + 1];
        int parent[] = new int[adjList.size() + 1], dist[] = new int[adjList.size() + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }

        queue.push(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int current = queue.pollFirst();

            for (int neighbour : adjList.get(current)) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                    dist[neighbour] = dist[current] + 1;
                    parent[neighbour] = current;
                }
            }

            System.out.println("Current: " + current + " :" + adjList.get(current) + " Queue: " + queue
                    + " Distance of current: " + dist[current]);
        }
        System.out.println();

        System.out.println("Shorted Distance is: " + dist[dest]);
        System.out.println("Shortest Path: ");

        int temp = dest;
        while (temp != -1) {
            System.out.print("<--" + temp);
            temp = parent[temp];
        }

    }

    public static void main(String[] args) {
        GenericGraph<Integer> snakeLadder = new GenericGraph<>();
        int[] board = new int[50];
        board[2] = 13;
        board[5] = 2;
        board[9] = 18;
        board[18] = 11;
        board[17] = -13;
        board[20] = -14;
        board[24] = -8;
        board[25] = -10;
        board[32] = -2;
        board[34] = -22;

        for (int u = 0; u < 36; u++) {
            // Throw dice
            for (int dice = 1; dice <= 6; dice++) {
                int v = u + dice + board[u + dice];
                snakeLadder.insert(u, v);
            }
        }

        // snakeLadder.printGraph();
        int d = snakeLadder.distance(0, 36);
        System.out.println(d);

    }
}
