package Exercicios.Exercicio07;
import java.util.LinkedList;
import java.util.Queue;

public class Exercicio07 {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();

        fila.offer("Diego");
        fila.offer("Alice");
        fila.offer("Patricia");
        fila.offer("Rita");

        int cont = 1;
        while (!fila.isEmpty()){
            System.out.println(cont + "º a sair: " + fila.poll());
            cont++;
        }
    }
}
