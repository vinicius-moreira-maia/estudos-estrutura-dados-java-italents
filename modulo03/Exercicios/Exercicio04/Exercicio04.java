// Arquivo Exercicio04.java
public class Exercicio04 {
    public static void main(String[] args) {
        int[] array = {-11, -4, -1, 0, 10, 44, 111, 8977, 120000};

        System.out.println(buscaBinaria(array, 111));
    }

    public static int buscaBinaria(int[] array, int valor) {
        int inicio = 0;
        int fim = array.length - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            // vê se o valor está no meio
            if (array[meio] == valor) {
                return meio;
            }

            // se for maior, ignora a metade da esquerda
            if (array[meio] < valor) {
                inicio = meio + 1;
            } 
            // se for menor, ignora a metade da direita
            else {
                fim = meio - 1;
            }
        }

        return -1;
    }

}
