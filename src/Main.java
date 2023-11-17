import java.util.*;

public class Main {

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(12);
        graph.addEdge(3, 10);
        graph.addEdge(3, 8);
        graph.addEdge(5, 11);
        graph.addEdge(7, 11);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        graph.addEdge(11, 9);
        graph.addEdge(11, 2);
        graph.addEdge(11, 10);
        List<Integer> list = graph.topologicallySort();
        System.out.println("Ordenaçao Topológica: " + list);

        System.out.println("===========================================");

        DirectedGraph cyclicGraph = new DirectedGraph(4);
        cyclicGraph.addEdge(0, 1);
        cyclicGraph.addEdge(1,2);
        cyclicGraph.addEdge(2,3);
        cyclicGraph.addEdge(3, 1);
        List<Integer> resultado = cyclicGraph.topologicallySort();
        System.out.println("Ordenaçao Topológica: " + resultado);
    }
}
