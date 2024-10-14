package Exercicios.Exercicio02;
import java.util.ArrayList;

public class Exercicio02 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();

        // lista com elementos duplicados
        for (int i = 1; i <= 10; i++){
            lista.add(i);
            lista.add(i);
        }

        System.out.println(lista);

        Exercicio02.removeDupl(lista);

        // ArrayList é passado por referência, portanto o método altera a lista, não preciso retorná-la ou retornar uma cópia
        System.out.println(lista);
    }

    public static void removeDupl(ArrayList<Integer> lista) {
        ArrayList<Integer> semDupl = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            Integer elemento = lista.get(i);
            
            // se a lista sem duplicados nao contém o elemento, adicionar
            if (!semDupl.contains(elemento)) {
                semDupl.add(elemento);
            }
        }

        // trocando os elemetos da lista pelos elementos não duplicados
        lista.clear();
        lista.addAll(semDupl);
    }
}
