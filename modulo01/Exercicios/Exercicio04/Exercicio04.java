package modulo01.Exercicios.Exercicio04;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String opcao;

        while (true) {
            System.out.print("'c' para sair - 'a' para adicionar - 'd' para deletar - 'l' para listar: ");
            opcao = scanner.nextLine(); 

            if (opcao.equals("c")) {

                break;

            } else if (opcao.equals("a")) {
                
                System.out.print("Digite o número a ser adicionado: ");
                int num_add = Integer.parseInt(scanner.nextLine());
                lista.add(num_add);
                System.out.println(num_add + " adicionado");

            } else if (opcao.equals("d")) {
                
                System.out.print("Digite o número a ser deletado: ");
                int num_del = Integer.parseInt(scanner.nextLine());

                if (lista.contains(num_del)) {
                    lista.remove(Integer.valueOf(num_del));
                    System.out.println(num_del + " deletado");
                } else {
                    System.out.println(num_del + " não existe na lista");
                }

            } else if (opcao.equals("l")) {

                System.out.println(lista);

            } else {
                System.out.println("opção inválida");
            }
        }
        
        scanner.close();
    }
}