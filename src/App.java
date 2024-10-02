import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    CadastroJogadores cj = new CadastroJogadores();
    CadastroItens ci = new CadastroItens();
    Jogador jogadorOnline;

    public void executar(){
        Boolean cond = true;

        while (cond) {
            System.out.println("1. Cadastrar");
            System.out.println("2. Entrar");
            System.out.println("Any. Exit");
            int opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Digite o email do jogador: ");
                    String email = scanner.next();
                    System.out.println("Digite o nome do jogador: ");
                    String nome = scanner.next();
                    String pin = setPin();
                    jogadorOnline = new Jogador(email, nome, pin);
                    cj.addJogador(jogadorOnline);
                    break;

                case 2:
                    System.out.println("Digite o email do jogador: ");
                    email = scanner.next();
                    pin = setPin();
                    jogadorOnline = cj.getJogador(email, pin);
                    break;

                default:
                    cond = false;
                    break;
            }
        }
    }

    public String setPin() {
        System.out.println("Digite o pin do jogador: ");
        String pin = scanner.next();
        if(pin.length() != 6){
            setPin();
        }
        return pin;
    }
}
