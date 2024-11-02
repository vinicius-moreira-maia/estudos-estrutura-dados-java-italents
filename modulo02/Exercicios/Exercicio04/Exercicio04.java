package Exercicios.Exercicio04;
import java.util.ArrayDeque;
import java.util.Deque;

/*
 Expressõs balanceadas apenas checam se chaves, colchetes ou
 parênteses possuem um fechamento, ou seja, para todo (, [ ou {, deve
 existir um par correspondente que o fecha.
 */

public class Exercicio04 {
    public static void main(String[] args) {
        String expressao = "((2 + 3 * (4 - 5))"; 

        boolean estaBalanceada = verificarBalanceamento(expressao);

        if (estaBalanceada) {
            System.out.println("A expressão está balanceada.");
        } else {
            System.out.println("A expressão não está balanceada.");
        }
    }

    public static boolean verificarBalanceamento(String expressao) {
        Deque<Character> pilha = new ArrayDeque<>();

        // empilhando o parentese de abertura (
        // checando para ver se existe um par ) correspondente
        // se existir, desempilha
        // se for achado um ) com a pilha vazia, não está balanceada
        // se a pilha não estiver vazia no final, não está balanceada
        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            if (c == '(') {
                pilha.push(c);
            } else if (c == ')') {
                if (pilha.isEmpty()) {
                    return false;
                }
                pilha.pop();
            }
        }

        // Se a pilha estiver vazia, os parênteses estão balanceados
        return pilha.isEmpty();
    }
}
