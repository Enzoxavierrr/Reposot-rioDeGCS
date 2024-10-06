import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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


    //Lucas Simao - fazendo a lista de listar itens de um jogador em ordem alfabetica...
    public String listarItensJogadores(String dono) {
        for (Jogador j : Jogadores) {
            ArrayList<Item> itensDoJogador = j.getItens();

            Collections.sort(itensDoJogador, new Comparator<Item>() {
                @Override
                public int compare(Item i1, Item i2) {
                    return i1.getNome().compareTo(i2.getNome());
                }
            });

            StringBuilder listaDeItens = new StringBuilder();
            for (Item i : itensDoJogador) {
                listaDeItens.append(i.toString()).append("\n");
            }
            return listaDeItens.toString();
        }
        return "Jogador não encontrado!";
    }

    //Enzo Xavier: 3) O sistema deverá permitir a um jogador listar os itens dos demais jogadores, por ordem de preço.
    public String listarItensDosOutrosJogadoresPorValor(Jogador jogadorAtual) {
        StringBuilder resultado = new StringBuilder();

        for (Jogador j : Jogadores) {
            if (!j.equals(jogadorAtual)) {
                ArrayList<Item> itensDoJogador = j.getItens();
                Collections.sort(itensDoJogador, new Comparator<Item>() {
                    @Override
                    public int compare(Item i1, Item i2) {
                        return Double.compare(i2.getValor(), i1.getValor());
                                }
                });
                resultado.append("Itens do jogador ").append(j.getNome()).append(":\n");
                for (Item i : itensDoJogador) {
                    resultado.append(i.toString())
                            .append(" - Valor: ")
                            .append(i.getValor())
                            .append("\n");
                }
                resultado.append("\n");
            }
        }
        return resultado.toString();
    }

}