import java.util.*;

public class Main {

    public static void main(String[] args) {
        DirectedGraph grafo = new DirectedGraph(12);

        grafo.addEdge(3, 10);
        grafo.addEdge(3, 8);

        grafo.addEdge(5, 11);

        grafo.addEdge(7, 11);
        grafo.addEdge(7, 8);

        grafo.addEdge(8, 9);

        grafo.addEdge(11, 9);
        grafo.addEdge(11, 2);
        grafo.addEdge(11, 10);

        List<Integer> resultado = grafo.topologicallySort();
        System.out.println("Ordenaçao Topológica: " + resultado);
    }
}
