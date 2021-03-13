import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.text.html.parser.Entity;

public class GenericWeightedGraph<T> {

    HashMap<T, HashMap<T, Integer>> adjList;

    public GenericWeightedGraph() {
        adjList = new HashMap<>();
    }

    public void addEdge(T u, T v, boolean bidir, int weight) {

        addEdge(u, v, weight);
        if (bidir) {
            addEdge(v, u, weight);
        }

    }

    void addEdge(T u, T v, int w) {

        if (adjList.get(u) == null) {
            adjList.put(u, new HashMap<>());
        }

        adjList.get(u).put(v, w);
    }

    void printGraph() {

        for (Map.Entry<T, HashMap<T, Integer>> entries : adjList.entrySet()) {
            System.out.print(entries.getKey() + " --> ");

            HashMap<T, Integer> neigbours = entries.getValue();

            for (Map.Entry<T, Integer> neighbour : neigbours.entrySet()) {

                System.out.print(neighbour.getKey() + "(" + neighbour.getValue() + ") --> ");

            }

            System.out.println();

        }
    }

    HashMap<T, Integer> dijikstraShortestpath(T source) {

        HashSet<T> visited = new HashSet<>();
        LinkedList<T> queue = new LinkedList<>();
        HashMap<T, Integer> cost = new HashMap<>();
        visited.add(source);
        cost.put(source, 0);
        queue.add(source);

        HashMap<T, T> path = new HashMap<>();

        while (!queue.isEmpty()) {
            T current = queue.pollFirst();

            // System.out.print(current + " : ");
            HashMap<T, Integer> neighbours = adjList.get(current);
            for (Entry<T, Integer> neighbour : neighbours.entrySet()) {
                if (!visited.contains(neighbour.getKey())) {
                    queue.add(neighbour.getKey());
                    visited.add(neighbour.getKey());
                }

                int costToNeighbour = neighbour.getValue() + cost.get(current);
                if (!cost.containsKey(neighbour.getKey()) || costToNeighbour < cost.get(neighbour.getKey())) {
                    cost.put(neighbour.getKey(), costToNeighbour);
                    path.put(neighbour.getKey(), current);
                    // System.out.print(neighbour.getKey() + " --> " + costToNeighbour + " ,");
                }

            }
            // System.out.println();
        }

        // T temp = dest;
        // while (temp != null && !temp.equals(source)) {

        // System.out.print(temp + " <= ");
        // temp = path.get(temp);

        // }

        // if (temp == null) {
        // System.out.println("Unable to react from source to dest");
        // return Integer.MAX_VALUE;
        // }

        // System.out.println(source);

        return cost;
    }

}
