// Arquivo Exercicio03.java
public class Exercicio03 {
    public static void main(String[] args) {
        // busca linear
        int[] array = {3, 5, 6, 4, 6, 7, 8, 9, 12, 23, -2, 44};

        System.out.println(buscaLinear(array, 12));
    }

    public static int buscaLinear(int[] array, int num){
        for (int i = 0; i< array.length; i++){
            if (array[i] == num){
                return i;
            }
        }

        return -1;
    }
}
