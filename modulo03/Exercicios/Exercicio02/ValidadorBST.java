import modulo03.Exercicios.Exercicio01.ArvoreBinaria;
import modulo03.Exercicios.Exercicio01.Node;

public class ValidadorBST {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserirNode(1000);
        arvore.inserirNode(33);
        arvore.inserirNode(27);
        arvore.inserirNode(-33);
        arvore.inserirNode(0);
        arvore.inserirNode(28);
        arvore.inserirNode(59);

        System.out.print("Elementos em ordem: ");
        arvore.emOrdem();

        if (isBST(arvore)) {
            System.out.println("é!");
        } else {
            System.out.println("não é!");
        }
    }

    public static boolean isBST(ArvoreBinaria arvore) {
        // começa com esses limites, pois "não sei" quais os valores contidos na árvore, então uso o limite permitido pelo tipo do dado
        return isBSTRec(arvore.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTRec(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        // se o valor do nó estiver fora dos limites min e max, não é uma BST
        if (node.valor <= min || node.valor >= max) {
            return false;
        }

        // aqui os limites superior e inferior são atualizados com o valor do nó atual
        // no caso da esquerda o valor do nó deve ser maior que o valor mínimo
        // no caso da direita o valor deve ser menor que o valor máximo
        return isBSTRec(node.left, min, node.valor) && 
               isBSTRec(node.right, node.valor, max);
    }
}