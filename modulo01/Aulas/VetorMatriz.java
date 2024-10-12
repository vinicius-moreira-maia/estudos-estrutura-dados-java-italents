package modulo01.Aulas;
import java.util.Scanner;

public class VetorMatriz {
    public static void main(String[] args) {
        
        // array vazio, com tamanho definido
        int[] arr = new int[5];

        // populando
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 10;
        }

        // exibindo
        for (int n: arr) {
            System.out.println(n);
        }

        // forma simples de descobrir o tipo de um objeto
        System.out.println("Tipo de objeto: " + arr.getClass().getSimpleName());

        // matriz vazia com tamanho pré-definido
        int[][] matriz = new int[2][2];

        // matriz populada
        int[][] matriz2 = {{2, 2}, {3, 4}};

        // Scanner
        // A classe System é uma classe que trás várias funcionalidades sobre o ambiente de execução
        Scanner scanner = new Scanner(System.in);
        
        // usando o Scanner para definir o tamanho do array dinamicamente
        int[] vet;
        System.out.print("Tamanho do vetor: ");
        vet = new int[scanner.nextInt()]; // ou Integer.parseInt(scanner.nextLine())
        System.out.print("Tamanho " + vet.length + "\n");

        // o nextInt não consome a linha digitada até o fim (incluindo o '\n')
        // portanto preciso consumí-la antes de prosseguir, senão dará erro de leitura nas próximas entradas
        // poderia usar Integer.parseInt também, no vetor
        scanner.nextLine();
        
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();  // nextLine() lê uma linha completa como String
        
        // Lendo um int
        System.out.print("Digite sua idade: ");
        int idade = Integer.parseInt(scanner.nextLine());  // convertendo o tipo (precisa tratar exceção)
        
        // Exibindo os valores lidos
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);

        scanner.close();
    }
}
