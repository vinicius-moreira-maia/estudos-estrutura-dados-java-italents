package modulo01.Exercicios.Exercicio10;

public class Item {
    private String nome;
    private Double preco;

    public Item(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return this.nome;
    }

    public Double getPreco() {
        return this.preco;
    }

    @Override
    public String toString() {
        return "    " + "Nome: " + this.getNome() + " / Preço: " + this.getPreco();
    }
}
