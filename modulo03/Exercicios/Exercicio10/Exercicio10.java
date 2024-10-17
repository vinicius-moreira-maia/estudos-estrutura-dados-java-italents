import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Exercicio10 {
    private Map<String, List<Aresta>> adjacencias;

    public Exercicio10() {
        adjacencias = new HashMap<>();
    }

    public void addVertice(String rotulo) {
        adjacencias.put(rotulo, new ArrayList<>());
        System.out.println("Vertice adicionado: " + rotulo); // Log
    }

    public void addAresta(String origem, String destino) {
        if (!adjacencias.containsKey(origem)) {
            addVertice(origem);
        }

        if (!adjacencias.containsKey(destino)) {
            addVertice(destino);
        }

        adjacencias.get(origem).add(new Aresta(destino));
        System.out.println("Aresta adicionada: " + origem + " -> " + destino); // Log
    }

    private class Aresta {
        private String destino;

        public Aresta(String destino) {
            this.destino = destino;
        }

        public String getDestino() {
            return destino;
        }
    }

    public List<String> ordenacaoTopologica() {
        List<String> ordenacao = new ArrayList<>();
        Map<String, Boolean> visitados = new HashMap<>();

        for (String vertice : adjacencias.keySet()) {
            visitados.put(vertice, false);
        }

        LinkedList<String> pilha = new LinkedList<>();

        for (String vertice : adjacencias.keySet()) {
            if (!visitados.get(vertice)) {
                dfsTopo(vertice, visitados, pilha);
            }
        }

        while (!pilha.isEmpty()) {
            ordenacao.add(pilha.pop());
        }

        return ordenacao;
    }

    private void dfsTopo(String vertice, Map<String, Boolean> visitados, LinkedList<String> pilha) {
        visitados.put(vertice, true);
        System.out.println("Visitando: " + vertice); 

        List<Aresta> vizinhos = adjacencias.get(vertice);
        for (Aresta aresta : vizinhos) {
            if (!visitados.get(aresta.getDestino())) {
                dfsTopo(aresta.getDestino(), visitados, pilha);
            }
        }

        pilha.push(vertice);
        System.out.println("Pilha atualizada com: " + vertice);
    }

    public static void main(String[] args) {
        Exercicio10 grafo = new Exercicio10();

        grafo.addAresta("Brasil", "Jamaica");
        grafo.addAresta("Jamaica", "China");

        List<String> resultado = grafo.ordenacaoTopologica();

        System.out.println("Ordenação topológica: " + resultado);
    }
}