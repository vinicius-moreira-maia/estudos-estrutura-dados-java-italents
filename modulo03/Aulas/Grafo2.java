package modulo03.Aulas;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Grafo2 {
    // é só pensar que 'adjacencias' seria um dicionário onde cada valor é uma lista, no Python
    // {chave1: [], chave2: [] ... chaven: []} 
    // no Java é preciso definir muito bem esse tipo de dado
    // mapa/matriz de adjacências
    private Map<String, List<Aresta>> adjacencias;

    public Grafo2(){
        // adjacencias = {}, no Python
        adjacencias = new HashMap<>();
    }

    public Map<String, Boolean> BST(String verticeInicial){
        Map<String, Boolean> visitados = new HashMap<>();
        Queue<String> fila = new LinkedList<>();

        // populando o dicionário com todas as chaves da matriz de adjacências do objeto Grafo2
        // todos recebem false a priori
        for (String vertice: adjacencias.keySet()){
            visitados.put(vertice, false);
        }

        // aqui eu mando pra fila o vértice inicial (recebido como parâmetro)
        // pois os primeiros vértices a serem visitados são os dele
        fila.add(verticeInicial);

        // é true, pois se trata do próprio vértice que foi recebido
        visitados.put(verticeInicial, true);

        // a fila começa com 1 (verticeInicial)
        while (!fila.isEmpty()){
            // tiro o elemento da fila para ser o vértice atual (o primeiro é o verticeInicial)
            String verticeAtual = fila.poll();

            // imprimindo o vértice atual
            System.out.print(verticeAtual + " ");

            // aqui, 'vizinhos' recebe a lista que contém as arestas/vizinhos ('Aresta') do 'verticeAtual'
            List<Aresta> vizinhos = adjacencias.get(verticeAtual);

            // "vizinho" é cada objeto do tipo Aresta na lista de cada chave do dicionário
            for (Aresta aresta : vizinhos) {
                // se o vizinho do verticeAtual ainda não tiver sido visitado
                if (!visitados.get(aresta.getDestino())){
                    fila.add(aresta.getDestino()); // adiciono a aresta (vizinho) para ser visitada
                    visitados.put(aresta.getDestino(), true); // marco o vizinho como visitado
                }
            }
        }

        System.out.println();
        return visitados;
    }

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

    // rótulo é o nome do vértice (a chave do dicionário, no Python)
    public void addVertice(String rotulo){
        // adjacencias[rotulo] = []
        adjacencias.put(rotulo, new ArrayList<>());
    }

    /* 
        Basicamente, esse método recebe o nome de dois nós (origem e destino) e o peso da aresta.
        Caso esses nós não existam, eles são adicionados em 'adjacencias' como chaves, com uma lista vazia como valor.
        Em seguida a origem é ligada ao destino, onde eu adiciono um objeto do tipo 'Aresta' na lista da chave correspondente.
        A 'Aresta' encapsula tanto o nome do destino (que já é uma chave independente em 'adjacencias') como o peso da conexão.
    */
    public void addAresta(String origem, String destino, int peso){
        if (!adjacencias.containsKey(origem)){
            addVertice(origem);
        }

        if (!adjacencias.containsKey(destino)){
            addVertice(destino);
        }

        adjacencias.get(origem).add(new Aresta(destino, peso));
    }

    /* 
    def imprimir():
        for vertice in adjacencias.keys():
            arestas = adjacencias[vertice]
            print(f"{vertice} -> " end = "")

            for aresta in arestas:
                print(f"{aresta.getDestino()}({aresta.getPeso}) " end = "")
            print()
    */

    public void imprimir(){
        // bem tranquilo, é só pensar em Python que toda essa sintaxe do Java passa batida
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
        private String destino; // é o nó/vértice de para onde a aresta aponta
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
        Grafo2 grafo = new Grafo2();

        // primeiro nó do grafo, rótulo é chave e o valor é uma lista vazia
        grafo.addVertice("Brasil");
        
        grafo.addVertice("Jamaica");
        grafo.addVertice("China");
        grafo.addVertice("Holanda");
        grafo.addVertice("Portugal");
        grafo.addVertice("Inglaterra");

        // adicionar "Brasil" e "Jamaica" de forma independente aqui acaba sendo redundante
        grafo.addAresta("Brasil", "Jamaica", 3);
        grafo.addAresta("Brasil", "Holanda", 2);
        grafo.addAresta("Holanda", "China", 6);
        grafo.addAresta("Jamaica", "Holanda", 1);
        grafo.addAresta("Jamaica", "China", 1);
        grafo.addAresta("China", "Brasil", 10);
        grafo.addAresta("China", "Holanda", 11);
        grafo.addAresta("China", "Jamaica", 8);
        grafo.addAresta("Holanda", "Brasil", 8);
        grafo.addAresta("Portugal", "Jamaica", 8);
        grafo.addAresta("Portugal", "Inglaterra", 8);
        grafo.addAresta("Inglaterra", "China", 8);

        // acessando manualmente
        //System.out.println(grafo.adjacencias.get("Brasil").get(0).getDestino());
        //System.out.println(grafo.adjacencias.get("Brasil").get(1).getDestino());

        grafo.imprimir();
        
        System.out.println();
        
        System.out.println("BFS:");
        grafo.BST("Brasil");

        System.out.println();

        System.out.println("DFS:");
        grafo.DFS("Brasil");
        System.out.println();
    }
}
