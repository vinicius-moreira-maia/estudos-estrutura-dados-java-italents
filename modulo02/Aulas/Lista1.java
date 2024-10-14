import java.util.ArrayList;

public class Lista1{
    public static void main(String[] args) {
        // em Java, arrays são diferentes de listas
        // listas são objetos dinâmicos (alocação dinâmica de memória)

        ArrayList<String> lista = new ArrayList<>();

        lista.add("Jurupinga");

        // isso é possível pois ArrayList implementa o método toString() (o equivalente ao __str__ do Python)
        System.out.println(lista);

        // há getters e setters para ArrayLists
        System.out.println(lista.get(0));
        lista.set(0, "Créu");

        System.out.println(lista.get(0));

        System.out.println(lista.size());

        lista.add("Brioco");
        lista.add("Trelólú");

        System.out.println(lista);
        
        // case sensitive
        System.out.println(lista.contains("Brioco"));

        lista.remove("Brioco");

        System.out.println(lista);

        lista.clear();
        System.out.println(lista);

    }
}