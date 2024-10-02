import java.util.ArrayList;

public class CadastroProposta {
    private ArrayList<Proposta> propostas;

    public CadastroProposta() {
        this.propostas = new ArrayList<>();
    }

    public ArrayList<Proposta> listaPropostas(Jogador jogadorLogado) {
        ArrayList<Proposta> propostasDisponiveis = new ArrayList<>();
        for (Proposta proposta : propostas) {
            if(proposta.getOfereceProp().getPin().equals(jogadorLogado.getPin())||proposta.getRecebeProp().getPin().equals(jogadorLogado.getPin())){
                propostasDisponiveis.add(proposta);
            }
        }
        return propostasDisponiveis;
    }

}
