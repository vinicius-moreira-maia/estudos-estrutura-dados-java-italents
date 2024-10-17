package modulo03.Aulas;

public class ArvoreBinaria {
    Node root;

    public ArvoreBinaria(){
        root = null;
    }

    // classes estáticas são classes aninhadas independentes da instância da classe "mãe"
    static class Node {
        String nome; // dado chave
        Node left, right;

        public Node(String nome){
            this.nome = nome;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        // a árvore agora possui apenas o root vazio
        ArvoreBinaria arvore = new ArvoreBinaria();

        // atributo de arvore é um Node!
        // agora o root possui dois nós filhos
        arvore.root = new Node("AAA");
        arvore.root.left = new Node("BBB");
        arvore.root.right = new Node("CCC");

        arvore.root.right.right = new Node("DDD");
        arvore.root.right.left = new Node("EEE");

        System.out.println(arvore.root.nome);
        System.out.println(arvore.root.left.nome);
        System.out.println(arvore.root.right.nome);
        System.out.println(arvore.root.right.right.nome);
        System.out.println(arvore.root.right.left.nome);
    }
}
