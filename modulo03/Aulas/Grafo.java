package modulo03.Aulas;
import java.util.LinkedList;

public class Grafo {

    // quantidade de vértices do grafo
    private int nVertices;

    // lista para guardar as conexoes presentes no grafo
    // lista de adjacências
    private LinkedList<Integer> adjacencias[];

    public Grafo(int nVertices){
        this.nVertices = nVertices;

        // lista de tamanho igual ao número de vétices recebidos no construtor
        adjacencias = new LinkedList[nVertices];

        // criando a lista de listas, de tamanho igual ao número de vértices
        for (int i = 0; i < nVertices; i++) {
            adjacencias[i] = new LinkedList();
        }
    }

    void addConexao(int vertice1, int vertice2){
        // conexão bilateral, nesse caso (há também conexões unilaterais)
        adjacencias[vertice1].add(vertice2);
        adjacencias[vertice2].add(vertice1);
    }


    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);

        // vertice 0 se liga com o vertice 1
        grafo.addConexao(0, 1);
        grafo.addConexao(0, 2);
        grafo.addConexao(0, 3);
        grafo.addConexao(0, 4); // até 4, pois o tamanho da lista de adjacências vai de 0 a 4
        grafo.addConexao(3, 2);
        grafo.addConexao(3, 0); // aqui é uma conexão repetida, posso incluir uma checagem disso
        grafo.addConexao(3, 1);

        // mostrando as conexões do nó 0
        System.out.println(grafo.adjacencias[0]);

    }
}
