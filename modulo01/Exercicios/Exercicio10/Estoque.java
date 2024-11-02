package modulo01.Exercicios.Exercicio10;
import java.util.Scanner;

public class Estoque {
    private int capacidade;
    private Item[] guardaItems;
    private int qtdItems;

    public Estoque(int capacidade) {
        this.capacidade = capacidade;
        this.guardaItems = new Item[this.capacidade];
        this.qtdItems = 0;
    }

    public boolean itemExists(int index) {
        if (this.guardaItems[index] == null) {
            return false;
        } else {
            return true;
        }
    }

    public void addItem(Item objItem) {
        if (this.qtdItems < this.capacidade) {
            for (int i = 0; i < this.guardaItems.length; i++) {
                if (this.guardaItems[i] == null) {
                    this.guardaItems[i] = objItem;
                    this.qtdItems++;
                    System.out.println("Item adicionado!");
                    break;
                }
            }
        } else {
            System.out.println("O estoque está cheio!");
        }
    }

    public void deleteItem(int index) {
        if (this.qtdItems > 0) {
            this.guardaItems[index] = null;
            this.qtdItems--;
        } else {
            System.out.println("O estoque está vazio!");
        }
    }

    public void updateItem(int index, String nome, double valor, boolean del) {
        if (del) {
            this.guardaItems[index] = null;    
        }else{
            this.guardaItems[index].setNome(nome);
            this.guardaItems[index].setPreco(valor);
        }
    }

    public static void deleteItem(Scanner scanner, Estoque estoque, int capacidade){
        int opcaoNumerica;
        while (true) {

            System.out.print("Escolha o item que deseja excluir ou -1 para sair: ");

            try {
                opcaoNumerica = Integer.parseInt(scanner.nextLine());

                if (opcaoNumerica < -1 || opcaoNumerica > capacidade - 1) {
                    throw new IllegalArgumentException();
                } else if (opcaoNumerica == -1) {
                    break;
                } else if (!estoque.itemExists(opcaoNumerica)) {
                    throw new IllegalArgumentException();
                } else {
                    estoque.updateItem(opcaoNumerica, "del", 0, true);
                    System.out.println("Produto removido!");
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Opção inválida, ou o número digitado não corresponde a um Item.");
            } catch (IllegalArgumentException e) {
                System.out.println("Item inexistente.");
            }
        }
    }

    public static void updateItem(Scanner scanner, Estoque estoque, int capacidade) {
        int opcaoNumerica;
        while (true) {
            System.out.print("Escolha o item que deseja editar, -1 para para sair:");

            try {
                opcaoNumerica = Integer.parseInt(scanner.nextLine());

                if (opcaoNumerica < -2 || opcaoNumerica > capacidade - 1) {
                    throw new IllegalArgumentException();
                } else if (opcaoNumerica == -1) {
                    break;
                } else if (!estoque.itemExists(opcaoNumerica)) {
                    throw new IllegalArgumentException();
                } else {
                    System.out.print("Digite o novo nome do Item: ");
                    String novoNome = scanner.nextLine();

                    double novoValor;

                    while (true) {
                        System.out.print("Digite o novo valor do Item: ");
                        try {
                            novoValor = Double.parseDouble(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Digite um número!");
                        }
                    }

                    estoque.updateItem(opcaoNumerica, novoNome, novoValor, false);
                    System.out.println("Produto alterado!");
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Opção inválida, ou o número digitado não corresponde a um Item.");
            } catch (IllegalArgumentException e) {
                System.out.println("Item inexistente.");
            }
        }
    }

    public void printEstoque() {
        for (int i = 0; i < this.guardaItems.length; i++) {
            System.out.println("   " + i + " " + this.guardaItems[i]);
        }
    }
}
