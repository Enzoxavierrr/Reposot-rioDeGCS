import java.util.ArrayList;

public class CadastroProposta {
    private ArrayList<Proposta> propostas;

    public CadastroProposta() {
        propostas = new ArrayList<>();
    }

    public void addProposta(Proposta proposta) {
        propostas.add(proposta);
    }

    public void listarPropostas(Jogador jogador) {
        for (Proposta proposta : propostas) {
            if (proposta.getRecebeProp().equals(jogador)) {
                System.out.println(proposta.toString());
            }
        }
    }

    public int propostasAceitas() {
        int cont = 0;
        for (Proposta proposta : propostas) {
            if (proposta.isAceita()) {
                cont++;
            }
        }
        return cont;
    }

    public int propostasDeclinadas() {
        int cont = 0;
        for (Proposta proposta : propostas) {
            if (proposta.isDeclinada()) {
                cont++;
            }
        }
        return cont;
    }

    public int propostasAguardando() {
        int cont = 0;
        for (Proposta proposta : propostas) {
            if (!proposta.isRespondida()) {
                cont++;
            }
        }
        return cont;
    }
}