import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

// exercícios 6 e 7

public class Grafo {
    private Map<String, List<Aresta>> adjacencias;

    public Grafo(){
        adjacencias = new HashMap<>();
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        grafo.addVertice("Fortaleza");
        grafo.addVertice("Caucaia");
        grafo.addVertice("Cascavel");
        grafo.addVertice("Natal");

        grafo.addAresta("Fortaleza", "Caucaia");
        grafo.addAresta("Caucaia", "Fortaleza");
        grafo.addAresta("Fortaleza", "Natal");
        grafo.addAresta("Caucaia", "Cascavel");
        grafo.addAresta("Cascavel", "Natal");
        grafo.addAresta("Natal", "Fortaleza");
        grafo.addAresta("Natal", "Caucaia");

        //grafo.BST("Natal");
        grafo.DFS("Fortaleza");
    }

    public void addVertice(String rotulo){
        adjacencias.put(rotulo, new ArrayList<>());
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

    private class Aresta{
        private String destino;

        public Aresta(String destino){
            this.destino = destino;
        }

        public String getDestino(){
            return destino;
        }
    }

    // exercicio 6
    public Map<String, Boolean> BST(String verticeInicial){
        Map<String, Boolean> visitados = new HashMap<>();
        Queue<String> fila = new LinkedList<>();

        for (String vertice: adjacencias.keySet()){
            visitados.put(vertice, false);
        }

        fila.add(verticeInicial);

        visitados.put(verticeInicial, true);

        while (!fila.isEmpty()){
            String verticeAtual = fila.poll();

            System.out.print(verticeAtual + " ");

            List<Aresta> vizinhos = adjacencias.get(verticeAtual);

            for (Aresta aresta : vizinhos) {
                if (!visitados.get(aresta.getDestino())){
                    fila.add(aresta.getDestino());
                    visitados.put(aresta.getDestino(), true);
                }
            }
        }
        
        System.out.println();
        return visitados;
    }

    // exercicio 07
    public Map<String, Boolean> DFS(String verticeInicial){
        Map<String, Boolean> visitados = new HashMap<>();

        for (String vertice : adjacencias.keySet()) {
            visitados.put(vertice, false);
        }

        DfsRec(verticeInicial, visitados);

        return visitados;
    }

    public void DfsRec(String vertice, Map<String, Boolean> visitados){
        visitados.put(vertice, true);

        System.out.print(vertice + " ");

        List<Aresta> vizinhos = adjacencias.get(vertice);

        for (Aresta aresta : vizinhos) {
            if (!visitados.get(aresta.getDestino())){
                DfsRec(aresta.getDestino(), visitados);
            }
        }
    }
}


