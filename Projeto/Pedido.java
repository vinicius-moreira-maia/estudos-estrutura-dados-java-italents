package Projeto;

import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Pizza> pizzas;
    private double valorTotal;

    public Pedido(int id, Cliente cliente, List<Pizza> pizzas, double valorTotal){
        this.id = id;
        this.cliente = cliente;
        this.pizzas = pizzas;
        this.valorTotal = valorTotal;
    }

    // método criado (não stava previsto)
    @Override
    public String toString(){
        String retorno = "Pedido nº " + id + "\n";
        retorno += "    Cliente: " + cliente.getNome() + "\n";
        retorno += "    Telefone: " + cliente.getTelefone()+ "\n";

        // O preço do objeto do tipo Pizza recebe o retorno do método 'getPrecoJusto', definido lá no cardápio 
        retorno += "    Pizzas:"+ "\n";
        int i = 1;
        for (Pizza pizza : pizzas) {
            retorno += "     pizza " + i + "\n";
            retorno += "        Sabores: " + pizza.getSabores()+ "\n";
            retorno += "        Preço: " + pizza.getPreco()+ "\n";
            retorno += "        Tamanho: " + pizza.getTamanho()+ "\n";
            i++;
        }
        
        retorno += "\n";

        return retorno;
    }

    // método criado (não stava previsto)
    public List<Pizza> getPizzas(){
        return pizzas;
    }

    // método criado (não stava previsto)
    public void setPizzas(Pizza pizza){
        pizzas.add(pizza);
    }
}
