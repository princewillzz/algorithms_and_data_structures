import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class GenericGraph<T> {
    Map<T, List<T>> adjList;

    GenericGraph() {
        adjList = new HashMap<>();
    }

    List<T> topologicalSort() {
        LinkedList<T> sortedVertices = new LinkedList<>();

        HashSet<T> visited = new HashSet<>();
        for (T key : adjList.keySet()) {

            if (!visited.contains(key)) {
                System.out.println("key : " + key);
                topologicalSorthelper(key, sortedVertices, visited);
            }
        }

        return sortedVertices;

    }

    private void topologicalSorthelper(T current, LinkedList<T> sortedVert, HashSet<T> visited) {
        visited.add(current);

        for (T neighbour : adjList.get(current)) {

            if (!visited.contains(neighbour)) {
                topologicalSorthelper(neighbour, sortedVert, visited);
            }

        }
        sortedVert.addFirst(current);

    }

    int distance(T source, T dest) {
        LinkedList<T> queue = new LinkedList<>();
        HashSet<T> visited = new HashSet<>();

        // HashMap<T, Integer> dist = new HashMap<>();
        HashMap<T, T> parent = new HashMap<>();

        // dist.put(source, 0);
        queue.add(source);
        visited.add(source);
        while (!queue.isEmpty()) {
            T current = queue.pollFirst();

            if (current.equals(dest)) {

                int dist = 0;
                // Create path
                Stack<T> path = new Stack<>();
                current = dest;
                path.push(current);
                while (!current.equals(source)) {
                    current = parent.get(current);
                    path.push(current);
                    dist++;
                }

                System.out.println("The path is : ");
                while (!path.isEmpty()) {
                    System.out.print(path.pop() + " --> ");
                }
                System.out.println();

                return dist;
                // return dist.get(dest);
            }

            for (T node : adjList.get(current)) {
                if (!visited.contains(node)) {
                    queue.add(node);
                    // dist.put(node, dist.get(current) + 1);
                    parent.put(node, current);
                    visited.add(node);
                }
            }

            // System.out.println("Current: " + current + " :" + adjList.get(current) + "
            // Queue: " + queue
            // + " Parent of current: " + parent.get(current));

        }

        return Integer.MAX_VALUE;
    }

    void DFS2(T source) {
        System.out.println("\n\nDFS2 ----> Source: " + source);
        Stack<T> queue = new Stack<>();
        queue.add(source);
        HashSet<T> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            T key = queue.pop();
            visited.add(key);
            System.out.print(key + " -> ");
            List<T> neighbours = adjList.get(key);

            for (T city : neighbours) {
                if (!visited.contains(city)) {
                    queue.add(city);
                }
            }

        }
        System.out.println();

    }

    void BFS(T source) {

        System.out.println("\n\nBFS ----> Source: " + source);
        LinkedList<T> queue = new LinkedList<>();
        queue.add(source);
        HashSet<T> visited = new HashSet<>();
        visited.add(source);
        while (!queue.isEmpty()) {
            T key = queue.pollFirst();

            System.out.print(key + " -> ");
            List<T> neighbours = adjList.get(key);

            for (T city : neighbours) {
                if (!visited.contains(city)) {
                    queue.add(city);
                    visited.add(city);
                }
            }

        }
        System.out.println();

    }

    void DFS(T source) {

        System.out.println("\n\nDFS ----> started From Source : " + source);
        HashSet<T> visited = new HashSet<>();
        helperDFS(source, visited);
    }

    void helperDFS(T source, HashSet<T> visited) {
        visited.add(source);
        System.out.print(source + " -> ");

        List<T> neighbours = adjList.get(source);
        for (int index = neighbours.size() - 1; index >= 0; index--) {
            T city = neighbours.get(index);
            if (!visited.contains(city)) {
                helperDFS(city, visited);
            }

        }

    }

    public void insert(T source, T dest, boolean bidir) {

        insert(source, dest);
        if (bidir) {
            insert(dest, source);
        }

    }

    public void insert(T source, T dest) {

        List<T> connections = adjList.get(source);
        if (connections == null) {
            connections = new ArrayList<>();
        }
        connections.add(dest);

        adjList.put(source, connections);

    }

    void printGraph() {

        adjList.entrySet().stream().forEach(p -> {

            System.err.print(p.getKey() + " --> ");
            for (T city : p.getValue()) {
                System.out.print(city + " ");
            }
            System.out.println();
        });

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GenericGraph<String> g = new GenericGraph<>();

        g.insert("Delhi", "Rajasthan", true);
        g.insert("Bangalore", "Delhi", true);
        g.insert("Kolkata", "Rajasthan", true);
        g.insert("Chennai", "Kolkata", true);
        g.insert("Delhi", "Mumbai", true);
        g.insert("Mumbai", "Pune", true);
        g.insert("Pune", "Chennai", true);
        g.insert("Pune", "Bangalore", true);

        g.printGraph();

        g.BFS("Kolkata");
        g.DFS2("Kolkata");
        g.DFS("Kolkata");

        System.out.println("\nDistance from _ to: ");
        System.out.println("The DIstance is: " + g.distance(sc.next(), sc.next()));

    }

}
