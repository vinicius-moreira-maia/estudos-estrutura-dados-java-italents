package modulo01.Aulas;

public class Objeto {
    // É boa prática em POO manter os atributos privados (encapsulamento)

    // atributos de instância
    private int idade;
    private String nome;

    // atributo de classe (static)
    public static String teste = "Atributo de classe";

    // construtor ('this' é o 'self' do java)
    // construtor é para inicializar atributos, não para definí-los / e deve(?) ser público
    public Objeto(int idade, String nome){
        this.idade = idade;
        this.nome = nome;
    }

    // Sobrescrevendo o método especial toString
    // o equivalente ao __str__ do Python
    // há o equals, hashcode ... métodos da classe java.lang.Object (a "superclasse suprema")
    @Override
    public String toString() {
        return "Nome: " + this.nome + ", Idade: " + this.idade;
    }

    // método get
    public String getNome(){
        return this.nome;
    }

    // método set
    public void setNome(String novo_nome){
        this.nome = novo_nome;
    }

    public static void main(String[] args) {

        Objeto pessoa = new Objeto(30,"Viniboy");
        
        // System.out.println(pessoa.getNome());
        // System.out.println(Objeto.teste);
        
        System.out.println(pessoa); // chamando o método toString
        pessoa.setNome("Birolíudo");
        System.out.println(pessoa);
    }
}
