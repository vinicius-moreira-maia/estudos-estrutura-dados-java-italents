package Projeto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

import Projeto.Pizza.TamanhoPizza;

public class Pizzaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> listaClientes = new ArrayList<>();
        List<Pedido> listaPedidos = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {
            System.out.println();
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Fazer um novo pedido");
            System.out.println("2 - Alterar um pedido");
            System.out.println("3 - Adicionar um cliente");
            System.out.println("4 - Gerar relatório de vendas");
            System.out.println("5 - Gerar lista de clientes");
            System.out.println("6 - Gerar lista de pedidos"); // esse print eu adicionei (não estava previsto)
            System.out.println("7 - Calcular frete"); // esse print eu adicionei (não estava previsto)
            System.out.println("9 - Sair");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcao) {
                case 1:
                    fazerPedido(scanner, listaPedidos, listaClientes);
                    break;
                case 2:
                    alterarPedido(listaPedidos, scanner);
                    break;
                case 3:
                    listaClientes.add(adicionarCliente(scanner)); 
                    System.out.println("Cliente adicionado com sucesso!");
                    break;
                case 4:
                    gerarRelatorio(listaPedidos);
                    break;
                case 5:
                    gerarListaClientes(listaClientes);
                    break;
                case 6: // esse case eu adicionei (não estava previsto)
                    gerarListaPedidos(listaPedidos);
                    break;
                case 7: // esse case eu adicionei (não estava previsto)
                    calcularFrete(listaPedidos, scanner);
                    break;
                case 9:
                    System.out.println("Até amanha...");
                    continuar = false;
                    scanner.close();
                    break;
                default:
                    break;
            }
        }
    
    }

    private static void fazerPedido(Scanner scanner, List<Pedido> listaPedidos, List<Cliente> listaClientes) {
        List<Pizza> pizzas = new ArrayList<>();
        System.out.println("FAZER PEDIDO");

        int x = 1;
        System.out.println("Selecione um cliente: ");
        for (Cliente cliente : listaClientes) {
            System.out.println(x+" - "+cliente.getNome());
            x++;
        }
        System.out.print("Opção: ");
        int cliente = scanner.nextInt();
        scanner.nextLine();

        boolean continuar = true;
        while (continuar) {
            x = 1;
            System.out.println("Qual o tamanho da pizza? ");
            System.out.println("Selecione um tamanho: ");
            for (TamanhoPizza tamanhos : Pizza.TamanhoPizza.values()) {
                System.out.println(x+" - "+tamanhos);
                x++;
            }
            System.out.print("Opção: ");
            int tamanho = scanner.nextInt();
            scanner.nextLine();

            int quantiSabores = 0;
            while (quantiSabores < 1 || quantiSabores > 4) {
                System.out.println("Digite a quantidade de sabores: 1 - 4 ");
                System.out.print("Opção: ");
                quantiSabores = scanner.nextInt();
                scanner.nextLine();
            }

            Cardapio cardapio = new Cardapio();
            List<String> saboresList = new ArrayList<>();
            List<String> saboresSelect = new ArrayList<>();

            for (int i = 0; i < quantiSabores; i++) {
                System.out.println("Selecione um sabor: ");

                x = 1;
                for (String sabor : cardapio.getCardapio().keySet()) {
                    saboresList.add(sabor);
                    System.out.println(x+" - "+sabor);
                    x++;
                }
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();
                saboresSelect.add(saboresList.get(opcao-1));
            }

            Pizza pizza = new Pizza(saboresSelect, cardapio.getPrecoJusto(saboresSelect), TamanhoPizza.getByIndex(tamanho-1));
            pizzas.add(pizza);

            System.out.println("Pizza cadastrada com sucesso!");
            System.out.println();
            System.out.println("Deseja cadastrar mais uma pizza no pedido?");
            System.out.print("1 - Sim, 2 - Não: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if(opcao != 1){
                continuar = false;
            }
        }
        Pedido pedido = new Pedido(listaPedidos.size()+1,listaClientes.get(cliente-1), pizzas, somarPizzas(pizzas));
        listaPedidos.add(pedido);
    }

    private static double somarPizzas(List<Pizza> pizzas) {
        double valorTotal = 0;
        for (Pizza pizza : pizzas) {
            valorTotal += pizza.getPreco();
        }
        return valorTotal;
    }

    // REQUISITO 1 DA TAREFA
    private static void alterarPedido(List<Pedido> pedidos, Scanner scanner){
        if (!pedidos.isEmpty()){
            boolean continuar = true;

            while (continuar) {

                gerarListaPedidos(pedidos);

                // escolhendo pedido pelo id
                System.out.println("Escolha o id de um pedido: ");
                System.out.print("Opção: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                // pedido escolhido
                // pedido agora é um alias para o objeto da lista, portanto alterar ele significa alterar ele também na lista
                Pedido pedido = pedidos.get(id - 1);
                System.out.println("Pedido escolhido:");
                System.out.println(pedido);

                System.out.println("O que deseja fazer? ");
                System.out.println("1 - para adicionar mais pizzas.");
                System.out.println("2 - para remover alguma pizza.");
                System.out.println("3 - para alterar o sabor de uma pizza.");
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        Pizza novaPizza = montarPizza(scanner);
                        pedido.setPizzas(novaPizza);
                        System.out.println("Pizza adicionada!");
                        continuar = false;
                        break;
                    case 2:
                        while (true){
                            System.out.println("Escolha o id da pizza que deseja remover.");
                            System.out.print("Opção: ");
                            int idPizza = scanner.nextInt();
                            scanner.nextLine();
                            
                            try {
                                pedido.getPizzas().remove(idPizza - 1);
                                System.out.println("Pizza removida!");
                                continuar = false;
                                break;   
                            } catch (Exception e) {
                                System.out.println("Id inválido!!");
                            }
                        }

                        break;
                    case 3:
                        while (true){
                            System.out.println("Escolha o id da pizza que deseja alterar.");
                            System.out.print("Opção: ");
                            int idPizza = scanner.nextInt() - 1;
                            scanner.nextLine();
                        
                            try {
                                Pizza pizzaEscolhida = pedido.getPizzas().get(idPizza);

                                int i = 1;
                                System.out.println("Sabores da pizza escolhida:");
                                for (String sabor : pizzaEscolhida.getSabores()) {
                                    System.out.print(i + " - " + sabor + "\n");
                                    i++;                                    
                                }
                                System.out.println();

                                System.out.println("Escolha o id do sabor que deseja alterar.");
                                System.out.print("Opção: ");
                                int idSaborExistente = scanner.nextInt() - 1;
                                scanner.nextLine();

                                Cardapio cardapio = new Cardapio();
                                List<String> sabores = new ArrayList<>(cardapio.getCardapio().keySet());

                                int j = 1;
                                for (String sabor : sabores) {
                                    System.out.print(j + " - " + sabor + "\n");
                                    j++;
                                }

                                System.out.println("Escolha o id do novo sabor.");
                                System.out.print("Opção: ");
                                int idNovoSabor = scanner.nextInt() - 1;
                                scanner.nextLine();

                                // alterando o sabor da pizza
                                List<String> saboresExistentes = pizzaEscolhida.getSabores();
                                saboresExistentes.set(idSaborExistente, sabores.get(idNovoSabor));
                                pizzaEscolhida.setSabores(saboresExistentes);
                                double novoPreco = cardapio.getPrecoJusto(saboresExistentes);
                                pizzaEscolhida.setPreco(novoPreco);

                                System.out.println("Pizza alterada!");
                                continuar = false;
                                break;   
                            } catch (Exception e) {
                                System.out.println("Id inválido!!");
                            }
                        }
                        
                        break;
                    case 9:
                        continuar = false;
                        scanner.close();
                        break;
                    default:
                        break;
            }
        }
        }else{
            System.out.println("Não há pedidos para escolher. Faça um pedido.");
        }
    }

    // método criado (não stava previsto)
    private static Pizza montarPizza(Scanner scanner) {
        int x = 1;
        System.out.println("Qual o tamanho da pizza? ");
        System.out.println("Selecione um tamanho: ");
    
        for (TamanhoPizza tamanho : Pizza.TamanhoPizza.values()) {
            System.out.println(x + " - " + tamanho);
            x++;
        }

        int tamanhoSelecionado = -1;
        while (tamanhoSelecionado < 1 || tamanhoSelecionado > Pizza.TamanhoPizza.   values().length) {
            System.out.print("Opção: ");
            try {
                tamanhoSelecionado = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, selecione um   número.");
                scanner.nextLine(); 
            }
        }
        scanner.nextLine();

        int quantiSabores = 0;
        while (quantiSabores < 1 || quantiSabores > 4) {
            System.out.println("Digite a quantidade de sabores: 1 - 4 ");
            System.out.print("Opção: ");
            try {
                quantiSabores = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, selecione um número.");
                scanner.nextLine(); 
            }
        }
        scanner.nextLine();

        Cardapio cardapio = new Cardapio();
        List<String> saboresSelect = new ArrayList<>();

        for (int i = 0; i < quantiSabores; i++) {
            System.out.println("Selecione um sabor: ");

            x = 1;
            List<String> saboresList = new ArrayList<>(cardapio.getCardapio().keySet()); // Reinicia a lista a cada iteração
            for (String sabor : saboresList) {
                System.out.println(x + " - " + sabor);
                x++;
            }

            int opcaoSabor = -1;
            while (opcaoSabor < 1 || opcaoSabor > saboresList.size()) {
                System.out.print("Opção: ");
                try {
                opcaoSabor = scanner.nextInt();
                } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, selecione um número.");
                scanner.nextLine();
                }
            }
        scanner.nextLine();
            saboresSelect.add(saboresList.get(opcaoSabor - 1));
        }

        Pizza pizza = new Pizza(saboresSelect, cardapio.getPrecoJusto   (saboresSelect), TamanhoPizza.getByIndex(tamanhoSelecionado - 1));
    
        return pizza;
    }

    // REQUISITO 2 DA TAREFA
    private static Map<String, Integer> getSaboresMaisPedidos(List<Pedido> pedidos){
        Map<String, Integer> saboresPedidos = new HashMap<>();

        // criando o mapa com os sabores
        for (Pedido pedido : pedidos) {
            for (Pizza pizza : pedido.getPizzas()) {
                List<String> listaSabores = pizza.getSabores();
                for (String sabor : listaSabores) {
                    if (!saboresPedidos.containsKey(sabor)){
                        saboresPedidos.put(sabor, 0);
                    }
                }
            }    
        }

        // verificando a quantidade de vendas de cada sabor
        for (Pedido pedido : pedidos) {
            for (Pizza pizza : pedido.getPizzas()) {
                List<String> listaSabores = pizza.getSabores();
                for (String sabor : listaSabores) {
                    if (saboresPedidos.containsKey(sabor)){
                        saboresPedidos.put(sabor, saboresPedidos.get(sabor) + 1);
                    }
                }
            }    
        }

        // montando o mapa com os sabores mais vendidos
        Map<String, Integer> saboresMaisPedidos = new HashMap<>();
        for (String sabor : saboresPedidos.keySet()) {
            if (saboresPedidos.get(sabor) >= 1){
                saboresMaisPedidos.put(sabor, saboresPedidos.get(sabor));
            }
        }

        return saboresMaisPedidos;
    } 

    // REQUISITO 2 DA TAREFA
    private static void gerarRelatorio(List<Pedido> pedidos) {
        Grafo grafo = new Grafo();
        double receitaTotal = 0.0;

        // esse método retorna os sabores que vnderam 1 ou mais vezes
        Map<String, Integer> saboresMaisPedidos = getSaboresMaisPedidos(pedidos);

        // criando a matriz/mapa de adjacências
        for (Pedido pedido : pedidos) {
            
            // calculando o total (o método 'somarPizzas' já existia)
            receitaTotal += somarPizzas(pedido.getPizzas());

            for (Pizza pizza : pedido.getPizzas()) {
                List<String> listaSabores = pizza.getSabores();
                for (String sabor : listaSabores) {
                    grafo.addVertice(sabor);
                }
            }    
        }

        // criando as arestas de cada chave
        for (Pedido pedido : pedidos) {
            for (Pizza pizza : pedido.getPizzas()) {
                List<String> listaSabores = pizza.getSabores();
                for (String sabor : listaSabores) {
                    if (listaSabores.contains(sabor)) {
                        for (String outroSabor : listaSabores) {
                            // condição para não relacionar um sabor com ele mesmo
                            if (!outroSabor.equals(sabor)) {
                                grafo.addAresta(sabor, outroSabor);
                            }
                        }
                    }
                }
            }    
        }

        System.out.println("-> Relatório:\n");
        System.out.println("Faturamento total: " + receitaTotal + "\n");
        System.out.println("Sabores mais pedidos: " + saboresMaisPedidos + "\n");
        System.out.println("Ligação entre os sabores mais pedidos:");
        for (String sabor : saboresMaisPedidos.keySet()) {
            grafo.DFS(sabor);   
        }
    }

    // REQUISITO 3 DA TAREFA
    private static void calcularFrete(List<Pedido> pedidos, Scanner scanner) {
        
        gerarListaPedidos(pedidos);
        Pedido pedido = null;
        double distanciaKms = 1.0;
        double totalFrete = 0.0;

        while (true){
            try {
                System.out.println("Escolha o id de um pedido para calcular o frete: ");
                System.out.print("Opção: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                pedido = pedidos.get(id - 1);
                System.out.println("Pedido escolhido:");
                System.out.println(pedido);

                System.out.println("Escolha a distância (em km): ");
                System.out.print("Opção: ");
                distanciaKms = Double.parseDouble(scanner.nextLine());
                System.out.println();
                break;
            } catch (Exception e) {
                System.out.println("Entrada inválida.");
            }
        }

        int quantidadePizzasPedido = pedido.getPizzas().size();

        totalFrete = (quantidadePizzasPedido * 1.50) + (distanciaKms * 2);

        System.out.println("Frete: " + totalFrete + "\n");
    }

    // método criado (não stava previsto)
    private static void gerarListaPedidos(List<Pedido> pedidos) {
        if (!pedidos.isEmpty()){
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        } else {
            System.out.println("Não há pedidos para exibir. Faça um pedido.");
        }
    }

    private static Cliente adicionarCliente(Scanner scanner) {
        System.out.println("ADICIONAR CLIENTE");
        System.out.println();
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println();
        System.out.print("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();
        System.out.println();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.println();
        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();
        System.out.println();

        Cliente cliente = new Cliente(nome, endereco, telefone, email);
        return cliente;
    }

    private static void gerarListaClientes(List<Cliente> listaClientes) {
        int x = 1;
        if (listaClientes.isEmpty()) {
            System.out.println("Lista de clientes esta vazia");
        } else {
            for (Cliente cliente : listaClientes) {
                System.out.println("Cliente "+x);
                System.out.println(cliente.getNome());
                System.out.println(cliente.getEndereco());
                System.out.println(cliente.getTelefone());
                System.out.println(cliente.getEmail());
                System.out.println();
                x++;
            }
        }
    }
}
