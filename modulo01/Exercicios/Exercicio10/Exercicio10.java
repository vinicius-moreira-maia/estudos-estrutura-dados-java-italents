package modulo01.Exercicios.Exercicio10;
import java.util.Scanner;

// shift + alt + f (indentação automática no vs code)

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // aqui está sem tratamento de erros
        System.out.print("Digite a capacidade do estoque: ");
        int capacidade = Integer.parseInt(scanner.nextLine());

        Estoque estoque = new Estoque(capacidade);

        String opcao = "";

        while (!opcao.equals("c")) {
            System.out.println("[c] para encerrar / [l] para listar / [a] para adicionar / [x] para escolher e editar / [d] para escolher e excluir: ");
            
            opcao = scanner.nextLine();

            if (opcao.equals("l")) {
                System.out.println("\nESTOQUE:");
                estoque.printEstoque();
                System.out.println();
            } else if (opcao.equals("a")) {
                System.out.print("Nome do produto: ");
                String nome = scanner.nextLine();
                System.out.print("Preço do produto: ");
                Double preco = Double.parseDouble(scanner.nextLine());
                estoque.addItem(new Item(nome, preco));
            } else if (opcao.equals("x")) {
                Estoque.updateItem(scanner, estoque, capacidade);
            } else if (opcao.equals("d")) {
                Estoque.deleteItem(scanner, estoque, capacidade);
            } else {
                System.out.println("");
            }
        }

        scanner.close();

    }
}
