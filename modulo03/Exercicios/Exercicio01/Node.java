package modulo03.Exercicios.Exercicio01;

public class Node {
    public int valor;
    public Node left;
    public Node right;

    public Node(int value) {
        // não preciso do 'this', pois os nomes 'value' e 'valor' são diferentes
        valor = value;
        left = right = null;
    }
}