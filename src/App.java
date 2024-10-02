import java.util.*;
public class App {

    public void App(){
        CadastroJogadores cadastroJogadores = new CadastroJogadores();
        CadastroItens cadastroItens = new CadastroItens();
        Scanner teclado = new Scanner(System.in);
        int opcao = 0;

        while(opcao != -1) {
            switch (opcao) {

                case 1:
                    System.out.println(">>> Cadastrar novo item <<<");
                    break;

                case 2:
                    System.out.println(">>> Excluir item <<<");
                    break;

                case 3:
                    System.out.println(">>> Listar meus itens (A - Z) <<<");
                    break;

                case 4:
                    System.out.println(">>> Listar itens de outro Jogador ($$) <<<");
                    break;

                case 5:
                    System.out.println(">>> Buscar Itens <<<");
                    break;

                case 6:
                    System.out.println(">>> Abrir Proposta de Troca <<<");
                    break;

                case 7:
                    System.out.println(">>> Listar as propostas de troca do jogador logado <<<");
                    break;

                case 8:
                    System.out.println(">>> Estatísticas Gerais <<<");
                    break;

                case 9:
                    System.out.println(">>> Funcionalidade 1 <<<");
                    break;

                case 10:
                    System.out.println(">>> Funcionalidade 2 <<<");
                    break;
            }
        }
    }
}