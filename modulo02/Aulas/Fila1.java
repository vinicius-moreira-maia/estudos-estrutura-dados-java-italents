import java.util.LinkedList;
import java.util.Queue;

public class Fila1 {
    public static void main(String[] args) {
        // FIFO (First in, First out)

        // fila como lista ligada
        Queue<String> fila = new LinkedList<>();

        // offer é o método de enfileirar novos objetos
        fila.offer("Neymar");
        fila.offer("Messi");
        fila.offer("Clodoaldo");

        // primeiro da fila
        //System.out.println(fila.peek());

        // remove e retorna o primeiro da fila
        //System.out.println(fila.poll());

        System.out.println(fila);

        while (!fila.isEmpty()){
            fila.poll();
        }

        System.out.println(fila);
    }
}
