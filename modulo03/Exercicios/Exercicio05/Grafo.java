import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Grafo {
    private Map<String, List<Aresta>> adjacencias;

    public Grafo(){
        adjacencias = new HashMap<>();
    }

    public void addVertice(String rotulo){
        adjacencias.put(rotulo, new ArrayList<>());
    }

    public void addAresta(String origem, String destino, int peso){
        if (!adjacencias.containsKey(origem)){
            addVertice(origem);
        }

        if (!adjacencias.containsKey(destino)){
            addVertice(destino);
        }

        adjacencias.get(origem).add(new Aresta(destino, peso));
    }
    
    public void imprimir(){
        for (String vertice: adjacencias.keySet()) {
            List<Aresta> arestas = adjacencias.get(vertice);
            System.out.print(vertice + " -> ");
            for (Aresta aresta: arestas) {
                System.out.print(aresta.getDestino() + "(" + aresta.getPeso() + ") ");
            }
            System.out.println();
        }
    }

    private class Aresta{
        private String destino;
        private int peso;

        public Aresta(String destino, int peso){
            this.destino = destino;
            this.peso = peso;
        }

        public String getDestino(){
            return destino;
        }

        public int getPeso(){
            return peso;
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        grafo.addVertice("Fortaleza");
        grafo.addVertice("Caucaia");
        grafo.addVertice("Cascavel");
        grafo.addVertice("Natal");

        grafo.addAresta("Fortaleza", "Caucaia", 1);
        grafo.addAresta("Caucaia", "Fortaleza", 1);
        grafo.addAresta("Fortaleza", "Natal", 7);
        grafo.addAresta("Caucaia", "Cascavel", 2);
        grafo.addAresta("Cascavel", "Natal", 5);
        grafo.addAresta("Natal", "Fortaleza", 7);
        grafo.addAresta("Natal", "Caucaia", 8);

        grafo.imprimir();
    }
}

