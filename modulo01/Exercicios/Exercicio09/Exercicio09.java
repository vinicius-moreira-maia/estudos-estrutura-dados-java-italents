package modulo01.Exercicios.Exercicio09;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio09 {
    public static void main(String[] args) {
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        String opcao = "";
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("'a' adicionar / número do elemento para remover / 'l' listar / 's' sair: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "a":
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Idade: ");
                    String idade = scanner.nextLine();

                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();

                    listaPessoas.add(new Pessoa(idade, nome, endereco));
                    
                    break;
                
                case "l":
                    int cont = 1;
                    for (Pessoa objeto: listaPessoas){
                        System.out.println(cont + " - " + objeto);
                        cont++;
                    }
                    break;
            
                default:
                    try {
                        System.out.print("Elemento para excluir: ");
                        int indice = Integer.parseInt(scanner.nextLine());
                        listaPessoas.remove(indice - 1);
                        System.out.println("elemento removido!");
                    } catch (Exception e) {
                        System.out.println("Entrada inválida!");
                    }
                    break;
            }

        }while(opcao != "s");

        scanner.close();
    }
}
