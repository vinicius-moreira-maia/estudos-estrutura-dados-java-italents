package Projeto;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Grafo
 {
    private Map<String, List<Aresta>> adjacencias;

    public Grafo(){
        adjacencias = new HashMap<>();
    }

    // busca em profundidade
    public Map<String, Boolean> DFS(String verticeInicial){
        Map<String, Boolean> visitados = new HashMap<>();

        for (String vertice : adjacencias.keySet()) {
            visitados.put(vertice, false);
        }

        System.out.print("Ligação entre os sabores: ");
        DfsRec(verticeInicial, visitados);
        System.out.println();

        return visitados;
    }

    public void DfsRec(String vertice, Map<String, Boolean> visitados){
        visitados.put(vertice, true);

        System.out.print(vertice + "| ");

        // recebendo a lista dos vizinhos do vérticeAtual
        List<Aresta> vizinhos = adjacencias.get(vertice);

        // uso de pilha implícita (pilha de chamados de funções)
        // se um camnho não tiver sido visitado, ele será visitado recursivamente / em profundidade
        for (Aresta aresta : vizinhos) {
            if (!visitados.get(aresta.getDestino())){
                DfsRec(aresta.getDestino(), visitados);
            }
        }
    }

    public void addVertice(String rotulo){
        if (!adjacencias.containsKey(rotulo)){
            adjacencias.put(rotulo, new ArrayList<>());
        }
    }

    public void addAresta(String origem, String destino){
        if (!adjacencias.containsKey(origem)){
            addVertice(origem);
        }

        if (!adjacencias.containsKey(destino)){
            addVertice(destino);
        }

        adjacencias.get(origem).add(new Aresta(destino));
    }

    // esse método não está sendo usado na aplicação
    public void imprimir(){
        for (String vertice: adjacencias.keySet()) {
            List<Aresta> arestas = adjacencias.get(vertice);
            System.out.print(vertice + " -> ");
            for (Aresta aresta: arestas) {
                System.out.print(aresta.getDestino() + " ");
            }
            System.out.println();
        }
    }

    private class Aresta{
        private String destino;

        public Aresta(String destino){
            this.destino = destino;
        }

        public String getDestino(){
            return destino;
        }
    }
}

