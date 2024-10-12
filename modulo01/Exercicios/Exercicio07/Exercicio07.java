package modulo01.Exercicios.Exercicio07;
import java.util.Scanner;

public class Exercicio07 {
    public static void main(String[] args) {
        String[][] matriz = {{"-","-","-"},
                             {"-","-","-"},
                             {"-","-","-"}};

        Scanner scanner = new Scanner(System.in);

        Exercicio07.exibir(matriz);

        while (true){
            System.err.print("jog 1 x: ");
            int jog1_x = Integer.parseInt(scanner.nextLine());
            System.err.print("jog 1 y: ");
            int jog1_y = Integer.parseInt(scanner.nextLine());

            matriz[jog1_x][jog1_y] = "X";

            Exercicio07.exibir(matriz);

            if (ganhou(matriz)){
                break;
            }

            System.err.print("jog 2 x: ");
            int jog2_x = Integer.parseInt(scanner.nextLine());
            System.err.print("jog 2 y: ");
            int jog2_y = Integer.parseInt(scanner.nextLine());

            matriz[jog2_x][jog2_y] = "O";

            Exercicio07.exibir(matriz);

            if (ganhou(matriz)){
                break;
            }
        }

        scanner.close();
    }

    public static void exibir(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean ganhou(String[][] matriz) {
        // linhas
        for (int i = 0; i < 3; i++) {
            if (!matriz[i][0].equals("-") && matriz[i][0].equals(matriz[i][1]) && matriz[i][1].equals(matriz[i][2])) {
                System.out.println("Jogador " + (matriz[i][0].equals("X") ? "1" : "2") + " ganhou!");
                return true;
            }
        }
    
        //colunas
        for (int i = 0; i < 3; i++) {
            if (!matriz[0][i].equals("-") && matriz[0][i].equals(matriz[1][i]) && matriz[1][i].equals(matriz[2][i])) {
                System.out.println("Jogador " + (matriz[0][i].equals("X") ? "1" : "2") + " ganhou!");
                return true;
            }
        }
    
        // diagonais
        if (!matriz[0][0].equals("-") && matriz[0][0].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][2])) {
            System.out.println("Jogador " + (matriz[0][0].equals("X") ? "1" : "2") + " ganhou!");
            return true;
        }
        if (!matriz[0][2].equals("-") && matriz[0][2].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][0])) {
            System.out.println("Jogador " + (matriz[0][2].equals("X") ? "1" : "2") + " ganhou!");
            return true;
        }
    
        return false;
    }
}
