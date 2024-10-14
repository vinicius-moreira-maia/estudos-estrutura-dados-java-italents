package Exercicios.Exercicio09;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Exercicio09 {
    public static void main(String[] args) {
        Map<String, Integer> mapa1 = new HashMap<>();
        Map<String, Integer> mapa2 = new HashMap<>();

        mapa1.put("banana", 1);
        mapa1.put("laranja", 8);
        mapa1.put("morango", 327);

        mapa2.put("banana", 3);
        mapa2.put("jaca", 2);
        mapa2.put("morango", 32);

        Map<String, Integer> novoMapa = Exercicio09.mescla(mapa1, mapa2);

        System.out.println(novoMapa);
    }

    public static Map<String, Integer> mescla(Map<String, Integer> mapa1, Map<String, Integer> mapa2) {
        Map<String, Integer> novoMapa = new HashMap<>(mapa1);
        Scanner scanner = new Scanner(System.in);

        for (String item1: mapa2.keySet()){
            if (novoMapa.containsKey(item1)) {
                System.out.println("-> " + item1 + " é chave nos dois mapas.");
                System.out.println("    Valor mapa1 (novoMapa): " + novoMapa.get(item1));
                System.out.println("    Valor mapa2: " + mapa2.get(item1));

                while (true){
                    System.out.print("-> deseja substituir o valor do mapa1(novoMapa) pelo valor do mapa2?: ");
                    String opcao = scanner.nextLine();

                    if (opcao.equals("s")){
                        novoMapa.put(item1, mapa2.get(item1));
                        break;
                    }else if (opcao.equals("n")){
                        break;
                    } else {
                        System.out.println("-> opção inválida!");
                    }
                }
            }
        }

        scanner.close();
        return novoMapa;
    }
}
