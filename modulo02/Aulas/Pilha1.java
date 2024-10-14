import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha1 {
    public static void main(String[] args) {
        // LIFO (Last in, First out)
        Deque<Integer> pilha = new ArrayDeque<>();

        pilha.push(55);
        pilha.push(56);
        pilha.push(57);

        // o último será o primeiro!
        //System.out.println(pilha);

        // o topo da pilha
        //System.out.println(pilha.peek());

        // removendo (retorna o elemento)
        //pilha.pop();

        // o topo agora é o elemento de "baixo"
        //System.out.println(pilha.peek());

        Deque<Integer> nova_pilha = new ArrayDeque<>(pilha);

        System.out.println(nova_pilha);
        while (!nova_pilha.isEmpty()){
            nova_pilha.pop();
        }

        System.out.println(nova_pilha);
    }
}
