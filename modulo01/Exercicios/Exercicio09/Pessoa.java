package modulo01.Exercicios.Exercicio09;

public class Pessoa {
    private String idade;
    private String endereco;
    private String nome;

    public Pessoa(String idade, String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // '__str__' no Python
    @Override
    public String toString(){
        return this.nome + " - " + this.idade + " - " + this.endereco;
    }
}
