package Exercicios.Exercicio06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Arquivo Exercicio06.java
public class Exercicio06 {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        String opcao = "";

        do {

            System.out.print("'a' adicionar / 'r' remover / 'e' exibir / 's' sair: ");
            opcao = scanner.nextLine();

            if (opcao.equals("s")){
                break;
            } else {
                switch (opcao) {
                    case "a":
                        System.out.print("Nome: ");
                        fila.offer(scanner.nextLine());           
                        break;
                    case "r":
                        fila.poll();
                        System.out.println("Elemento removido.");            
                        break;
                    case "e":
                        System.out.println(fila);            
                        break;
                    default:
                        System.out.println("opção inválida");
                        break;
                }
            }
        } while (!opcao.equals("c"));
    }
}
