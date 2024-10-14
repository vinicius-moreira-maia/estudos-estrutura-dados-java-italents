package Exercicios.Exercicio05;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;

public class Exercicio05 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 1; i <= 10; i++){
            lista.add(i);
        }

        System.out.println(lista);

        inverte(lista);

        System.out.println(lista);
    }

    public static void inverte(ArrayList<Integer> lista) {
        Deque<Integer> pilha = new ArrayDeque<>();

        for (int i = 0; i < lista.size(); i++) {
            pilha.push(lista.get(i));
        }

        lista.clear();

        while (!pilha.isEmpty()){
            lista.add(pilha.pop());
        }
    }
}
