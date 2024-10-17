package modulo03.Exercicios.Exercicio01;

// o exercício 8 também está aqui

// Classe que representa a árvore binária
// Essa é uma BST (Árvore Binária de Busca)!
public class ArvoreBinaria {
    public Node root;
    public int menor;

    public ArvoreBinaria() {
        root = null;
    }

    // método público para inserir novo nó
    public void inserirNode(int valor) {
        // inserção recursiva
        root = inserirNodeRec(root, valor);
    }

    // esse método insere o nó na posição adequada, respeitando a regra da BST (menor na esquerda, maior na direita)
    private Node inserirNodeRec(Node root, int valor) {

        // caso base da recursão, para inserir o nó no elemento root ou em algum nó que não possui filhos (folhas)
        if (root == null) {
            root = new Node(valor);
            return root;
        }

        // percorrendo recursivamente a sub-árvore da direita ou da esquerda, dependendo do valor de cada nó
        if (valor < root.valor) {
            root.left = inserirNodeRec(root.left, valor);
        } else if (valor > root.valor) {
            root.right = inserirNodeRec(root.right, valor);
        }

        return root;
    }

    // travessia em pré-ordem (root -> sub. esq. -> sub. dir.)
    public void preOrdem() {
        preOrdemRec(root);
        System.out.println(); // só para pular uma linha
    }

    private void preOrdemRec(Node node) {
        // se o node for null significa que chegou na folha (nó sem filhos)
        if (node != null) {
            System.out.print(node.valor + " "); // 1 - root
            preOrdemRec(node.left); // 2 - percorre sub-árvore da esquerda
            preOrdemRec(node.right); // 3 - percorre sub-árvore da direita
        }
    }

    // (sub. esq. -> root -> sub. dir.)
    public void emOrdem() {
        emOrdemRec(root);
        System.out.println();
    }

    private void emOrdemRec(Node node) {
        if (node != null) {
            emOrdemRec(node.left); // 1 - percorre sub-árvore da esquerda
            System.out.print(node.valor + " "); // 2 - root
            emOrdemRec(node.right); // 3 - percorre sub-árvore da direita
        }
    }

    public void posOrdem(){
        posOrdemRec(root);
        System.out.println();
    }

    private void posOrdemRec(Node node){
        if (node != null){
            posOrdemRec(node.right); // 1 - direita
            System.out.print(node.valor + " "); // 2 - root
            posOrdemRec(node.left); // 3 - esquerda
        }
    }

    // só é preciso passar o valor, pois o objeto já tem acesso ao root internamente
    boolean busca(int valor){
        return buscaRec(root, valor);
    }

    // implementação de busca binária em uma BST
    boolean buscaRec(Node root, int valor){

        // se o 'if' tem só uma linha não precisa de chaves
        if (root == null) return false;

        // testa o igual
        if (root.valor == valor) return true;

        // testa o maior e o menor
        if (valor < root.valor)
            return buscaRec(root.left, valor);
        else
            return buscaRec(root.right, valor);
    }

    // exercicio 08
    public int buscaMenor() {
        if (root == null) {
            System.out.println("árvore vazia!");
            return -1;
        }

        buscaMenorRec(root); 
        return menor;
    }

    // exercicio 08
    // basicamente a ideia é chegar no elemento mais a esquerda de toda a BST
    private void buscaMenorRec(Node root) {
        if (root.left == null) {
            menor = root.valor;
        } else {
            buscaMenorRec(root.left);
        }
    }


    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria(); // bst
        
        arvore.inserirNode(50);
        arvore.inserirNode(30);
        arvore.inserirNode(70);
        arvore.inserirNode(20);
        arvore.inserirNode(40);
        arvore.inserirNode(60);
        arvore.inserirNode(80);
        
        System.out.print("pre ordem: ");
        arvore.preOrdem();

        System.out.print("em ordem: ");
        arvore.emOrdem();

        System.out.print("pos ordem: ");
        arvore.posOrdem();

        System.out.println(arvore.buscaMenor());
    }
}
