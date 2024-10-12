package modulo01.Exercicios.Exercicio06;

public class Exercicio06 {
    public static void main(String[] args) {
        // excluindo logo o número 1, que não é primo
        for (int i = 2; i <= 100; i++){
            int cont = 0;

            // j deve ser menor que i, pois não faz sentido dividir i por um número maior que ele
            for (int j = 1; j <= i ; j++){
                if (i % j == 0){
                    cont++;
                }
            }

            // 2 divisores apenas, 1 e o próprio número
            if (cont == 2){
                System.out.println(" " + i);
            }
        }
    }
}
