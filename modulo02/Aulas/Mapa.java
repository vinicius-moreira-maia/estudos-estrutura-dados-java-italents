import java.util.HashMap;
import java.util.Map;

public class Mapa {
    public static void main(String[] args) {
        // dicionários, no Python
        // objetos, no JavaScript
        // HashMap, no Java
        // -> pares chave-valor !!

        // tem que dar tipo de chave e tipo de valor
        Map<String, Integer> dict = new HashMap<>();

        dict.put("João", 33);
        dict.put("Diego", 45);

        // KeySet é o tipo, é uma classe declarada dentro da classe HashMap (inner class)
        System.out.println(dict.keySet());
        System.out.println(dict.keySet().getClass().getName());

        // Values é o tipo, é uma classe declarada dentro da classe HashMap (inner class)
        System.out.println(dict.values());
        System.out.println(dict.values().getClass().getName());

        System.out.println(dict);
        
        System.out.println("-------------------");

        // remove e retorna o valor da chave
        System.out.println(dict.remove("Diego"));

        System.out.println(dict);

        // acessando um elemento
        System.out.println(dict.get("João"));

        System.out.println(dict.isEmpty());
    }
}
