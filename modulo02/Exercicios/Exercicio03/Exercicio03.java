package Exercicios.Exercicio03;
import java.util.ArrayList;

// Arquivo Exercicio03.java
public class Exercicio03 {
    public static void main(String[] args) {
        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();

        // lista com elementos duplicados
        for (int i = 0; i <= 10; i += 2){
            lista1.add(i);
        }

        // lista com elementos duplicados
        for (int i = 1; i <= 10; i += 2){
            lista2.add(i);
        }

        System.out.println(lista1);
        System.out.println(lista2);

        ArrayList<Integer> novaLista = Exercicio03.intercalar(lista1, lista2);

        System.out.println(novaLista);

    }

    public static ArrayList<Integer> intercalar(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        ArrayList<Integer> listaIntercalada = new ArrayList<>();
        int maiorTamanho = 0;

        // achando o tamanho da lista de maior tamanho
        if (lista1.size() > lista2.size()){
            maiorTamanho = lista1.size(); 
        } else {
            maiorTamanho = lista2.size();
        }

        for (int i = 0; i < maiorTamanho; i++){
            try {
                listaIntercalada.add(lista1.get(i));
            } catch (IndexOutOfBoundsException e) {
                {}; // usando bloco como o 'pass' do Python
            }

            try {
                listaIntercalada.add(lista2.get(i));
            } catch (IndexOutOfBoundsException e) {
                {};
            }
        }

        return listaIntercalada;
    }
}
