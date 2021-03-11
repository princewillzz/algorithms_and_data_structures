import java.util.List;

public class Toposort {

    public static void main(String[] args) {
        GenericGraph<String> g = new GenericGraph<>();

        g.insert("A", "B", true);
        g.insert("A", "C", true);
        g.insert("A", "D", true);
        g.insert("A", "G", true);
        g.insert("B", "E", true);
        g.insert("B", "D", true);
        g.insert("B", "F", true);
        g.insert("C", "D", true);
        g.insert("G", "H", true);
        g.insert("G", "I", true);
        g.insert("J", "K", true);

        List<String> sorted = g.topologicalSort();
        System.out.println("Sorted vertices: ");
        for (String vertex : sorted) {
            System.out.print(vertex + " ");
        }
        System.out.println();

    }

}
