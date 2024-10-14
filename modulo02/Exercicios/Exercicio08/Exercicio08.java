package Exercicios.Exercicio08;

import java.util.HashMap;
import java.util.Map;

// Arquivo Exercicio08.java
public class Exercicio08 {
    public static void main(String[] args) {
        Map<String, Integer> dict = new HashMap<>();

        String frase =  "três pratos de trigo para três tigres tristes";

        String palavra = "";

        for (int i = 0; i < frase.length(); i++){
            Character letra = frase.charAt(i); 
        
            if (!Character.isSpaceChar(letra)){
                palavra += letra;

                // condição necessária, pois a última palavra não estava sendo acessada
                if (i == frase.length() - 1){
                    //System.out.println(palavra);
                    palavra = "";
                    break;
                }
            } else{
                //System.out.println(palavra);

                if (dict.containsKey(palavra)) {
                    // sobrescrevendo o valor com ele mesmo, mas atualizado
                    dict.put(palavra, dict.get(palavra) + 1);
                } else {
                    dict.put(palavra, 1);
                }

                palavra = "";
            }
        }

        System.out.println(dict);
    }
}
