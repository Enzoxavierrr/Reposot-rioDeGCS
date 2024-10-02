import java.util.ArrayList;

public class Jogador {
    private String email;
    private String nome;
    private String pin;
    private ArrayList<Item> itens = new ArrayList<Item>();

    public Jogador(String email, String pin, String nome) {
        this.email = email;
        this.nome = nome;
        this.pin = pin;
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

    public void setPin(String pin) {this.pin = pin;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}