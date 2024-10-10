import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CadastroJogadores {
    private ArrayList<Jogador> jogadores;

    public CadastroJogadores() {
        jogadores = new ArrayList<>();
    }

    public boolean addJogador(Jogador jogador) {
        for (Jogador j : jogadores) {
            if (j.getPin().equals(jogador.getPin())) {
                return false;
            }
        }
        jogadores.add(jogador);
        return true;
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

    //Lucas Simao - fazendo a lista de listar itens de um jogador em ordem alfabetica...
    public String listarItensJogadores(String pin) {
        for (Jogador j : jogadores) {
            if (j.getPin().equals(pin)) {
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
        }
        return "Jogador não encontrado!";
    }


    //Enzo Xavier: 3) O sistema deverá permitir a um jogador listar os itens dos demais jogadores, por ordem de preço.
    public String listarItensDosOutrosJogadoresPorValor(Jogador jogadorAtual) {

        StringBuilder resultado = new StringBuilder();
        for (Jogador j : jogadores) {

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
                             resultado.append(i.toString()).append(" - Valor: ").append(i.getValor()).append("\n");
                            }
                     resultado.append("\n");
                }
         }
            if (resultado.length() == 0) {
                return "Nenhum item encontrado de outros jogadores.";
            }
                return resultado.toString();
        }


    //Enzo Xavier: 3) O sistema deverá permitir a um jogador listar os itens dos demais jogadores, por ordem de preço.
    public String listarItensDosOutrosJogadoresPorValor(String pin) {
        Jogador jogadorLogado = getJogadorPorPin(pin);

        if (jogadorLogado == null) {
            return "Jogador não encontrado!";
        }
        StringBuilder resultado = new StringBuilder();

        for (Jogador jogador : jogadores) {
            if (!jogador.equals(jogadorLogado)) {
                ArrayList<Item> itensDoJogador = jogador.getItens();
                Collections.sort(itensDoJogador, new Comparator<Item>() {
                    @Override
                    public int compare(Item i1, Item i2) {
                        return Double.compare(i2.getValor(), i1.getValor()); // Ordenação decrescente
                    }});

                resultado.append("Itens do jogador ").append(jogador.getNome()).append(":\n");

                for (Item item : itensDoJogador) {
                    resultado.append(item.toString());

                }

                resultado.append("\n");
            }
        }
        if (resultado.length() == 0) {
            return "Nenhum item encontrado de outros jogadores.";
        }

        return resultado.toString();
    }

    public Jogador getJogadorPorPin(String pin) {
        for (Jogador jogador : jogadores) {
            if (jogador.getPin().equals(pin)) {
                return jogador;
            }
        }
        return null;
    }

    public Jogador getRandomPlayer() {
        return jogadores.get((int) Math.random() * jogadores.size());
    }
}

