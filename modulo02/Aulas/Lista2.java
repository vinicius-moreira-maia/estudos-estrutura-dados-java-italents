import java.util.ArrayList;

public class Lista2{
    public static void main(String[] args) {
        // em Java, arrays são diferentes de listas
        // listas são objetos dinâmicos (alocação dinâmica de memória)

        ArrayList<String> lista = new ArrayList<>();

        lista.add("Ronaldo");
        lista.add("Maradona");
        lista.add("Romário");

        // é preciso fazer o "casting" do tipo do dado para o java aceitar a atribuição, pois clone() retorna um 'Object' genérico, e não um objeto da classe ArrayList
        // o correto é fazer isso com try catch
        ArrayList<String> nova_lista = (ArrayList<String>) lista.clone();

        System.out.println(nova_lista);
        System.out.println(nova_lista.isEmpty());

        /* 
        // usando o for normal (do C)
        for (int i = 0; i < nova_lista.size(); i++){
            System.out.println(nova_lista.get(i));
        }
        System.out.println();
        */

        // for tipo o do Python (for each)
        for (String elemento: nova_lista){
            System.out.println(elemento);
            
            if (elemento == "Neymar") {
                System.out.println("existe esse jogador");
            } else {
                System.out.println("não existe esse jogador");
            }
        }
    }
}