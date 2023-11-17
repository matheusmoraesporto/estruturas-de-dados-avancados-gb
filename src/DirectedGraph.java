import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DirectedGraph extends Graph {

    public DirectedGraph(int V) {
        super(V);
    }

    @Override
    public void addEdge(int v, int w) {
        super.addEdge(v, w);
        adj[v].add(w);
    }

    public List<Integer> sortTopologically() {
        int[] verticesDegree = calculateDegree();
        System.out.println("Degree is: " + Arrays.toString(verticesDegree));

        Queue<Integer> zeroDegreeQueue = initializeQueue(verticesDegree);
        System.out.println("Queue is: " + zeroDegreeQueue);

        List<Integer> sortedList = new ArrayList<>();
        while (!zeroDegreeQueue.isEmpty()) {
            int removedVertex = zeroDegreeQueue.poll();
            sortedList.add(removedVertex);
            reduceDegree(removedVertex, verticesDegree, zeroDegreeQueue);
        }

        if (sortedList.size() != V) {
            System.out.println("sotedList is: " + sortedList);
            System.out.println("verticesDegree is: " + Arrays.toString(verticesDegree));
            throw new IllegalArgumentException("There is a cycle in this graph!");
        }

        return sortedList;
    }

    /**
     * Realiza o cálculo do grau de entrada para cada vértice.
     * 
     * @return Uma lista de inteiros contendo o grau de cada vértice.
     */
    private int[] calculateDegree() {
        int[] degree = new int[V];
        for (List<Integer> arestas : adj) {
            for (int v : arestas) {
                degree[v]++;
            }
        }
        return degree;
    }

    /**
     * Inicializa a fila para a ordenação topologica com os vértices que possuem
     * grau 0.
     * 
     * @param degree Lista auxiliar com os graus dos vértices.
     * @return Fila contendo os vértices com grau 0.
     */
    private Queue<Integer> initializeQueue(int[] degree) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        return queue;
    }

    /**
     * Para cada aresta do vértice removido, decrementa o grau e caso este seja 0,
     * então é adicionado na fila para ordenação.
     * 
     * @param removedVertex Índice do vértice removido.
     * @param degree        Lista com os graus de cada vértice.
     * @param queue         Fila com os vértices de grau 0.
     */
    private void reduceDegree(int removedVertex, int[] degree, Queue<Integer> queue) {
        for (int v : adj[removedVertex]) {
            degree[v]--;
            if (degree[v] == 0) {
                queue.add(v);
            }
        }
    }
}
