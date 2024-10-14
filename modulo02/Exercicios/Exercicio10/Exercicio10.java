package Exercicios.Exercicio10;

import java.util.ArrayList;

// Arquivo Exercicio10.java
public class Exercicio10 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        int[] array = {3, 4, 2, 1, 0, -3, 4, 5};

        // populando
        for (int n:array){
            lista.add(n);    
        }

        System.out.println(lista);

        int menor = lista.get(lista.size() - 1);
        int novoComeco = lista.size() - 1;

        // selection sort - O(n^2)
        while (novoComeco < lista.size()){
            for (int i = novoComeco; i >= 0; i--){
                menor = lista.get(novoComeco);
                if (lista.get(i) < menor){
                    menor = lista.get(i);
    
                    // troca
                    int aux = lista.get(novoComeco);
                    lista.set(novoComeco, menor);
                    lista.set(i, aux);
                }
            }

            novoComeco--;
        }

        System.out.println(lista);
    }
}
