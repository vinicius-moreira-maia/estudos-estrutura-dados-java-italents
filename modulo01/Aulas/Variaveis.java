package modulo01.Aulas;

public class Variaveis {
    public static void main(String[] args) {
        
        // variáveis primitivas (parecidas com as do C)
        byte val = -128; // de -128 a 127 (256 possibilidades)
        short val1 = 32767; // -32768 a 32767
        int val2 = 2147483647; // limite superior

        // valores muito altos (precisa de 'L' no final)
        // limite superior
        long val3 = 9223372036854775807L;

        // 2.2 é double, 2.2F é float
        float val4 = 2.2F;
        double val5 = 2.2;

        // char deve ter aspas simples e apenas 1 caractere
        char n1 = '@';

        // true ou false
        boolean b1 = true;

        // constantes ("final")
        final double pi = 3.1413;
        
        // erro!
        // pi = 4.4;

        // variáveis não primitivas (onde os tipos de dados são classes)
        // possuem vários métodos públicos
        // Integer, Double, etc. são 'wrappers' dos tipos primitivos
        // qualquer classe é tipo não primitivo

        String nome = "Vinicius";
        System.out.println(nome.toUpperCase()); // método de String

        /* 
           - Enum (coleção de constantes/palavras)
             É um tipo especial de classe. Pode ter métodos, atributos e construtores. Portanto variáveis do tipo 'Dia' só 
             podem assumir os valores do Enum.
        */
        
        enum Dia {
            DOMINGO, SABADO
        }

        // Dia é o tipo de dado (classe/enum)
        Dia dia = Dia.SABADO;
        System.out.println(dia);

        // array
        int[] arr = {2, 3, 4, 22};

        // endereço do array na memória
        System.out.println(arr);
    }
}
