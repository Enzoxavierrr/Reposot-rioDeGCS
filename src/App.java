import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    CadastroJogadores cj = new CadastroJogadores();
    CadastroItens ci = new CadastroItens();
    CadastroProposta cp = new CadastroProposta();
    Jogador jogadorLogado;

    public void executar(){
        Boolean cond = true;

        while (cond) {
            System.out.println("1. Cadastrar");
            System.out.println("2. Entrar");
            System.out.println("Any. Exit");
            try {
                int opc = scanner.nextInt();

                switch (opc) {
                    case 1:
                        System.out.println("Digite o email do jogador: ");
                        String email = scanner.next();
                        System.out.println("Digite o nome do jogador: ");
                        String nome = scanner.next();
                        System.out.println("Digite o pin do jogador: ");
                        String pin = scanner.next();

                        jogadorLogado = new Jogador(email, nome, pin);
                        cj.addJogador(jogadorLogado);
                        System.out.println("Jogador cadastrado com sucesso!");
                        break;

                    case 2:
                        System.out.println("Digite o email do jogador: ");
                        email = scanner.next();
                        System.out.println("Digite o pin do jogador: ");
                        pin = scanner.next();

                        jogadorLogado = cj.getJogador(email, pin);

                        if (jogadorLogado != null) {
                            System.out.println("Login bem-sucedido!");
                        } else {
                            System.out.println("Email ou PIN incorretos!");
                        }
                        break;

                    default:
                        cond = false;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.next(); // Limpa o input inválido
            }
        }

        if (jogadorLogado != null) {
            cond = true;

            while (cond) {
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
                System.out.println("Any. Exit");

                try {
                    int opc = scanner.nextInt();

                    switch (opc) {
                        case 1:
                            System.out.println("Digite o nome do item: ");
                            String nomeItem = scanner.next();
                            System.out.println("Digite a descrição do item: ");
                            String descricao = scanner.next();
                            System.out.println("Digite o valor do item: ");
                            double valor = scanner.nextDouble();
                            String tipo = tipoItem();
                            System.out.println("Digite o PC (Pontos de Combate) do item: ");
                            int pc = scanner.nextInt();

                            Item i = new Item(nomeItem, descricao, tipo, valor, jogadorLogado, pc);
                            jogadorLogado.addItem(i);
                            ci.addItem(i);
                            System.out.println("Item cadastrado com sucesso!");
                            break;

                        case 2:
                            System.out.println("Escolha um item para remover:\n");
                            jogadorLogado.printItens();
                            int posi = (scanner.nextInt()) - 1;

                            i = jogadorLogado.getItem(posi);
                            jogadorLogado.removeItem(i);
                            ci.removeItem(i);
                            System.out.println("Item removido com sucesso!");
                            break;

                        case 3:
                            System.out.println("Itens do Jogador:\n");
                            jogadorLogado.printItens();
                            break;

                        case 4:
                            System.out.println("Itens dos outros jogadores:\n");
                            ci.printItens(jogadorLogado);
                            break;

                        case 5:
                            System.out.println("Digite parte do nome ou descrição do item: ");
                            String busca = scanner.next();
                            ci.buscarItem(busca);
                            break;

                        case 6:
                            System.out.println("Propostas de troca:\n");
                            cp.listarPropostas(jogadorLogado); // Certifique-se que esse método existe
                            break;

                        case 7:
                            System.out.println("Estatísticas gerais:\n");
                            System.out.println("Total de jogadores: " + cj.totalJogadores());
                            System.out.println("Total de itens: " + ci.totalItens());
                            System.out.println("Soma dos valores dos itens: " + ci.somaValorItens());
                            System.out.println("Propostas aceitas: " + cp.propostasAceitas());
                            System.out.println("Propostas declinadas: " + cp.propostasDeclinadas());
                            System.out.println("Propostas aguardando resposta: " + cp.propostasAguardando());
                            break;

                        case 8:
                            Item cartaMaisPC = ci.cartaMaisPC();
                            System.out.println("Carta com mais PC: " + cartaMaisPC.toString());
                            System.out.println("Dono da carta: " + cartaMaisPC.getDono().toString());
                            break;

                        case 9:
                            tipo = tipoItem();
                            ci.printItens(tipo);
                            break;

                        default:
                            cond = false;
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                    scanner.next(); // Limpa o input inválido
                }
            }
        }
    }

    private String tipoItem() {
        System.out.println("Diga o tipo da Carta:");
        System.out.println("1.Carta de dragão");
        System.out.println("2.Carta de planta");
        System.out.println("3.Carta de fogo");
        System.out.println("4.Carta de agua");

        String tipo = "";
        boolean valida = false;

        while (!valida) {
            try {
                System.out.println("Escolha uma opção (1-4): ");
                int opc = scanner.nextInt();
                switch (opc) {
                    case 1:
                        tipo = "Carta de dragão";
                        valida = true;
                        break;
                    case 2:
                        tipo = "Carta de planta";
                        valida = true;
                        break;
                    case 3:
                        tipo = "Carta de fogo";
                        valida = true;
                        break;
                    case 4:
                        tipo = "Carta de agua";
                        valida = true;
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Insira um número entre (1-4).");
                scanner.next(); // Limpa o input inválido
            }
        }
        return tipo;
    }
}