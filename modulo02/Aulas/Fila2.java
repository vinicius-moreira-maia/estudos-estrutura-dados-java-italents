import java.util.LinkedList;
import java.util.Queue;

public class Fila2 {
    private String pedido;
    private Double preco;
    private Integer quantidade;

    public Fila2(String pedido, Double preco, Integer quantidade){
        this.pedido = pedido;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @Override
    public String toString(){
        return this.pedido + " / " + this.preco + " / " + this.quantidade;
    }

    public static void main(String[] args) {
        Queue<Object> fila = new LinkedList<>();
        fila.offer(new Fila2("baião", 23.90, 2));

        System.out.println(fila);
    }
}
