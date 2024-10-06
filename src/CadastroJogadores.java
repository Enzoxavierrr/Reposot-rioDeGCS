import java.util.ArrayList;

public class CadastroJogadores {
    private ArrayList<Jogador> jogadores;

    public CadastroJogadores() {
        jogadores = new ArrayList<>();
    }

    public void addJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public Jogador getJogador(String email, String pin) {
        for (Jogador jogador : jogadores) {
            if (jogador.getEmail().equals(email) && jogador.getPin().equals(pin)) {
                return jogador;
            }
        }
        return null;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public int totalJogadores() {
        return jogadores.size();
    }
}
