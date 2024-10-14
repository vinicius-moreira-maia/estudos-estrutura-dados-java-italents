import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha2 {

   private String nome;
   private int idade;

   public Pilha2(String nome, int idade){
      this.idade = idade;
      this.nome = nome;
   }

   @Override
   public String toString(){
      return "Nome: " + this.nome + " - " + "Idade: " + this.idade;
   }

   public static void main(String[] args) {
      // objeto genérico para tipar
      Deque<Object> pilha = new ArrayDeque<>();

      // objeto específico
      Deque<Pilha2> pilha2 = new ArrayDeque<>();

      pilha.push(new Pilha2("Xiquim", 77));
      pilha.push(new Pilha2("Nhonho", 9));

      // como o tipo do Deque é um objeto genérico, precisei sobrescrever o toString para representar o objeto textualmente, caso contrário teria só um endereço de memória
      System.out.println(pilha);

      while (!pilha.isEmpty()){
         pilha.pop();
      }

      System.out.println(pilha);
   } 
}
