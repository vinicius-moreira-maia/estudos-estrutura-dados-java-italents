package modulo01.Exercicios.Exercicio02;
import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int inteiro = Integer.parseInt(scanner.nextLine());

        if (inteiro % 2 == 0){
            System.out.println("Par");
        } else {
            System.out.println("Ímpar");
        }

        scanner.close();
    }
}
