import java.util.Scanner;

public class App {


    public void executar(){
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== Menu de Opções =====");
            System.out.println("1. Cadastrar novo item");
            System.out.println("2. Excluir item");
            System.out.println("3. Listar meus itens (A - Z)");
            System.out.println("4. Listar itens de outro Jogador ($$)");
            System.out.println("5. Buscar Itens");
            System.out.println("6. Abrir Proposta de Troca");
            System.out.println("7. Listar as propostas de troca do jogador logado");
            System.out.println("8. Estatísticas Gerais");
            System.out.println("9. Funcionalidade 1");
            System.out.println("10. Funcionalidade 2");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Cadastrar novo item
                    break;

                case 2:
                    // Excluir item
                    break;

                case 3:
                    // Listar meus itens (A - Z)
                    break;

                case 4:
                    // Listar itens de outro Jogador ($$)
                    break;

                case 5:
                    // Buscar Itens
                    break;

                case 6:
                    // Abrir Proposta de Troca
                    break;

                case 7:
                    // Listar as propostas de troca do jogador logado
                    break;

                case 8:
                    // Estatísticas Gerais
                    break;

                case 9:
                    // Funcionalidade 1
                    break;

                case 10:
                    // Funcionalidade 2
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
