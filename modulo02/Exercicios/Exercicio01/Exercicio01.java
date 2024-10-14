package Exercicios.Exercicio01;
import java.util.ArrayList;

public class Exercicio01 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 1; i <= 10; i++){
            lista.add(i);
        }

        System.out.println(lista);

        // criando nova lista para não modificar a lista e iterar sobre ela no mesmo loop (erro clássico)
        ArrayList<Integer> novaLista = (ArrayList<Integer>) lista.clone();

        // contador para os elementos da lista original
        int cont = 0;

        // iterando na nova lista ao contrário
        for (int i = novaLista.size() - 1; i >= 0; i--){
            lista.set(cont, novaLista.get(i));
            cont++;
        }

        System.out.println(lista);
    }
}
