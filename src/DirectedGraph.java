import java.util.ArrayList;
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

    public List<Integer> topologicallySort() {
        int[] degree = calculateDegree();

        // Inicializa uma fila com vértices de grau de entrada zero
        Queue<Integer> fila = new LinkedList<>();
        for (int i = 0; i < this.V; i++) {
            if (degree[i] == 0) {
                fila.add(i);
            }
        }

        List<Integer> resultado = new ArrayList<>();
        // Processa os v�rtices em ordem topol�gica
        while (!fila.isEmpty()) {
            int u = fila.poll();
            resultado.add(u);

            // Reduz o grau de entrada de vértices adjacentes
            for (int v : this.adj[u]) {
                degree[v]--;
                if (degree[v] == 0) {
                    fila.add(v);
                }
            }
        }

        // Verifica se houve ciclo no grafo
        if (resultado.size() != this.V) {
            throw new IllegalArgumentException("O grafo cont�m um ciclo!");
        }

        return resultado;
    }

    /**
     * Calcula o grau de entrada para cada vértice
     */
    private int[] calculateDegree() {
        int[] degree = new int[this.V];
        for (List<Integer> arestas : this.adj) {
            for (int v : arestas) {
                degree[v]++;
            }
        }
        return degree;
    }
}
