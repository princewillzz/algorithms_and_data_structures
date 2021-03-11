import java.util.ArrayList;
import java.util.HashMap;
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

}
