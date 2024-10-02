import java.util.ArrayList;

public class Jogador {
    private String email;
    private String pin;
    private String nome;
    private ArrayList<Jogador> arrayJogadores = new ArrayList <Jogador>();

    public Jogador(String email, String pin, String nome) {
        this.email = email;
        setPin(pin);
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        if(pin.length()== 6){
            this.pin = pin;
        }else{
            this.pin = null;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}