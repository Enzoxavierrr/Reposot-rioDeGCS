import java.util.ArrayList;

public class CadastroJogadores {
    private ArrayList<Jogador> Jogadores;

    public CadastroJogadores() {
        Jogadores = new ArrayList<>();
    }

    public void addJogador(Jogador j) {
        Jogadores.add(j);
    }

    public Jogador getJogador(String email, String pin) {
        for (Jogador j : Jogadores) {
            if (j.getEmail().equals(email) && j.getPin().equals(pin)) {
                return j;
            }
        }
        return null;
    }

    public ArrayList<Jogador> getJogadores() {
        return Jogadores;
    }
}