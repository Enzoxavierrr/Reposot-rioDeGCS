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

    public ArrayList getJogadores() {
        return jogadores;
    }

    public int totalJogadores() {
        return jogadores.size();
    }

    public String listarItensDeOutrosJogadores(Jogador jogadorLogado) {
        StringBuilder itensOutros = new StringBuilder();
        for (Jogador jogador : jogadores) {
            if (!jogador.equals(jogadorLogado)) {
                for (Item item : jogador.getItens()) {
                    itensOutros.append(item.toString()).append("\n");
                }
            }
        }
        return itensOutros.length() > 0 ? itensOutros.toString() : "Nenhum item encontrado de outros jogadores.";
    }

    public Jogador getRandomPlayer() {
        return jogadores.get((int) Math.random() * jogadores.size());
    }
}

