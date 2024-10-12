package modulo01.Exercicios.Exercicio08;
import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i< numeros.length; i++){
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = Integer.parseInt(scanner.nextLine());
        }

        // assumindo que o primeiro é o maior
        int mais_frequente = numeros[0];
        int cont_maxima = 0;

        for (int i = 0; i < numeros.length; i++){
            int cont = 0;

            // comparar um elemento com toda a lista (complexidade quadrática)
            for (int j = 0; j < numeros.length; j++){
                if (numeros[i] == numeros[j]) {
                    cont++;
                }
            }
            
            if (cont > cont_maxima) {
                cont_maxima = cont;
                mais_frequente = numeros[i];
            }
        }

        System.out.println("Número que mais se repete: " + mais_frequente);

        scanner.close();
    }
}
