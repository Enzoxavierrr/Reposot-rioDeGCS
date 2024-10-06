import java.util.Calendar;

public class CadastroProposta {
    private int id;
    private Jogador ofereceProp;
    private Jogador recebeProp;
    private Item oferece;
    private Item recebe;
    private String diaHora;
    private boolean aceita; // Se a proposta foi aceita
    private boolean declinada; // Se a proposta foi recusada
    private boolean respondida; // Se a proposta foi respondida (aceita ou declinada)

    public void Proposta(Jogador ofereceProp, Jogador recebeProp, Item oferece, Item recebe) {
        Calendar calendar = Calendar.getInstance();
        int mes = calendar.get(Calendar.MONTH) + 1;

        this.id = Item.randCode();
        this.diaHora = calendar.get(Calendar.DAY_OF_MONTH) + "/" + mes + "/" + calendar.get(Calendar.YEAR)
                + " - " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);
        this.ofereceProp = ofereceProp;
        this.recebeProp = recebeProp;
        this.oferece = oferece;
        this.recebe = recebe;
        this.aceita = false; // Inicialmente a proposta não foi aceita
        this.declinada = false; // Inicialmente a proposta não foi recusada
        this.respondida = false; // Inicialmente a proposta não foi respondida
    }

    // Getters
    public int getId() {
        return id;
    }

    public Jogador getOfereceProp() {
        return ofereceProp;
    }

    public Jogador getRecebeProp() {
        return recebeProp;
    }

    public Item getOferece() {
        return oferece;
    }

    public Item getRecebe() {
        return recebe;
    }

    public String getDiaHora() {
        return diaHora;
    }

    // Métodos que indicam o status da proposta
    public boolean isAceita() {
        return aceita;
    }

    public boolean isDeclinada() {
        return declinada;
    }

    public boolean isRespondida() {
        return respondida;
    }

    // Métodos para aceitar ou declinar a proposta
    public void aceitar() {
        this.aceita = true;
        this.respondida = true;
    }

    public void declinar() {
        this.declinada = true;
        this.respondida = true;
    }

    @Override
    public String toString() {
        return "Proposta{" +
                "id=" + id +
                ", ofereceProp=" + ofereceProp.getNome() +
                ", recebeProp=" + recebeProp.getNome() +
                ", oferece=" + oferece.getNome() +
                ", recebe=" + recebe.getNome() +
                ", diaHora='" + diaHora + '\'' +
                ", aceita=" + aceita +
                ", declinada=" + declinada +
                ", respondida=" + respondida +
                '}';
    }
}