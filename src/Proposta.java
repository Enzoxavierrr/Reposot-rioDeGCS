
public class Proposta {

    int id;
    Jogador ofereceProp;
    Jogador recebeProp;
    Item oferece;
    Item recebe;
    String diaHora;


    public Proposta(Jogador ofereceProp,Jogador recebeProp,Item oferece,Item recebe) {
        id = randCode();
        diaHora = "f";
    }

    public static int randCode() {
        int codigo;
        do {
            codigo = (int) (Math.random() * 9999);
        } while (codigo < 1000);
        return codigo;
    }
}
