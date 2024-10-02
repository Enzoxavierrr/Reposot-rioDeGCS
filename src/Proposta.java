import java.util.Calendar;

public class Proposta {

    int id;
    Jogador ofereceProp;
    Jogador recebeProp;
    Item oferece;
    Item recebe;
    String diaHora;


    public Proposta(Jogador ofereceProp,Jogador recebeProp,Item oferece,Item recebe) {
        Calendar calendar = Calendar.getInstance();

        int mes = calendar.get(Calendar.MONTH);
        mes++;

        id = Item.randCode();
        diaHora = calendar.get(Calendar.DAY_OF_MONTH) + "/" + mes + "/" + calendar.get(Calendar.YEAR)+" - "
        + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);
        this.ofereceProp = ofereceProp;
        this.recebeProp = recebeProp;
        this.oferece = oferece;
        this.recebe = recebe;

    }

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
}
