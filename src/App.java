import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private final Scanner scanner = new Scanner(System.in);
    private final CadastroJogadores cadastroJogadores = new CadastroJogadores();
    private Jogador jogadorLogado;

    public void executar() {
        boolean continuar = true;

        while (continuar) {
            exibirMenuInicial();
            int opcao = lerOpcaoUsuario();

            switch (opcao) {
                case 1:
                    logarJogador();
                    break;
                case 2:
                    cadastrarJogador();
                    break;
                default:
                    continuar = false;
                    break;
            }
        }

        if (jogadorLogado != null) {
            gerenciarOpcoesJogador();
        }
    }

    private void exibirMenuInicial() {
        System.out.println("1. Entrar");
        System.out.println("2. Cadastrar");
        System.out.println("Outra opção. Sair");
    }

    private int lerOpcaoUsuario() {
        int opcao = -1;
        try {
            opcao = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira um número.");
            scanner.next();
        }
        return opcao;
    }

    private void logarJogador() {
        System.out.println("Digite o email do jogador: ");
        String email = scanner.next();
        System.out.println("Digite o pin do jogador: ");
        String pin = scanner.next();

        jogadorLogado = cadastroJogadores.getJogador(email, pin);

        if (jogadorLogado != null) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Email ou PIN incorretos!");
        }
    }

    private void cadastrarJogador() {
        System.out.println("Digite o nome do jogador: ");
        String nome = scanner.next();
        System.out.println("Digite o email do jogador: ");
        String email = scanner.next();
        System.out.println("Digite o pin do jogador: ");
        String pin = scanner.next();

        jogadorLogado = new Jogador(email, nome, pin);
        cadastroJogadores.addJogador(jogadorLogado);
        System.out.println("Jogador cadastrado com sucesso!");
    }

    private void gerenciarOpcoesJogador() {
        boolean continuar = true;

        while (continuar) {
            exibirMenuJogador();
            int opcao = lerOpcaoUsuario();

            switch (opcao) {
                case 1:
                    cadastrarItem();
                    break;
                case 2:
                    excluirItem();
                    break;
                case 3:
                    listarItensJogador();
                    break;
                case 4:
                    listarItensOutrosJogadores();
                    break;
                case 5:
                    buscarItem();
                    break;
                case 6:
                    listarPropostas();
                    break;
                case 7:
                    exibirEstatisticasGerais();
                    break;
                case 8:
                    exibirCartaMaisPontosCombate();
                    break;
                case 9:
                    listarItensPorTipo();
                    break;
                default:
                    continuar = false;
                    break;
            }
        }
    }

    private void exibirMenuJogador() {
        System.out.println("\nOpções:");
        System.out.println("1. Cadastrar item");
        System.out.println("2. Excluir item");
        System.out.println("3. Listar itens do jogador");
        System.out.println("4. Listar itens dos outros jogadores");
        System.out.println("5. Buscar item");
        System.out.println("6. Listar propostas");
        System.out.println("7. Exibir estatísticas gerais");
        System.out.println("8. Exibir carta com mais PC e dono");
        System.out.println("9. Exibir cartas de um tipo");
        System.out.println("Outra opção. Sair");
    }

    private void cadastrarItem() {
        System.out.println("Digite o nome do item: ");
        String nome = scanner.next();
        System.out.println("Digite a descrição do item: ");
        String descricao = scanner.next();
        System.out.println("Digite o valor do item: ");
        double valor = scanner.nextDouble();
        String tipo = selecionarTipoItem();
        System.out.println("Digite o PC (Pontos de Combate) do item: ");
        int pc = scanner.nextInt();

        Item item = new Item(nome, descricao, tipo, valor, jogadorLogado, pc);
        jogadorLogado.addItem(item);
        System.out.println("Item cadastrado com sucesso!");
    }

    private void excluirItem() {
        System.out.println("Escolha um item para remover:\n");
        jogadorLogado.printItens();
        int posicao = scanner.nextInt() - 1;

        Item item = jogadorLogado.getItem(posicao);
        jogadorLogado.removeItem(item);
        System.out.println("Item removido com sucesso!");
    }

    private void listarItensJogador() {
        System.out.println("Itens do Jogador:\n");
        jogadorLogado.printItens();
    }

    private void listarItensOutrosJogadores() {
        System.out.println("Itens dos outros jogadores:\n");
    }

    private void buscarItem() {
        System.out.println("Digite parte do nome ou descrição do item: ");
        String busca = scanner.next();
    }

    private void listarPropostas() {
        System.out.println("Propostas de troca:\n");
    }

    private void exibirEstatisticasGerais() {
        System.out.println("Estatísticas gerais:\n");
    }

    private void exibirCartaMaisPontosCombate() {
        System.out.println("Exibindo carta com mais pontos de combate...");
    }

    private void listarItensPorTipo() {
        String tipo = selecionarTipoItem();
        System.out.println("Exibindo cartas do tipo: " + tipo);
    }

    private String selecionarTipoItem() {
        System.out.println("Selecione o tipo do item:");
        System.out.println("1. Carta de dragão");
        System.out.println("2. Carta de planta");
        System.out.println("3. Carta de fogo");
        System.out.println("4. Carta de água");

        while (true) {
            try {
                System.out.println("Escolha uma opção (1-4): ");
                int opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        return "Carta de dragão";
                    case 2:
                        return "Carta de planta";
                    case 3:
                        return "Carta de fogo";
                    case 4:
                        return "Carta de água";
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Insira um número entre 1 e 4.");
                scanner.next(); // Limpa o input inválido
            }
        }
    }
}