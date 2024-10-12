package modulo01.Exercicios.Exercicio05;

public class Exercicio05 {
    public static void main(String[] args) {
        int[][] matriz = {{3, 4, 5, 2, 3, 4, 55},
                          {0, 3, -1, -44, 111, 1, 1},
                          {2, 44, 44, -1, 2, 3, -111}};
        
        // assumindo que o primeiro elemento é o menor, só para começar
        int maior = matriz[0][0];

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j];
                }
            }
        }

        System.out.println("Maior valor da matriz: " + maior);
    }
}
