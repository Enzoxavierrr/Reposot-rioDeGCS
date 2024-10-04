import java.util.ArrayList;
import java.util.Scanner;

public class Jogador {
    Scanner scanner = new Scanner(System.in);
    private String email;
    private String nome;
    private String pin; //IDENTIFICADOR, CADA UM TEM O SEU!
    private ArrayList<Item> itens = new ArrayList<Item>();
    private ArrayList<Proposta> propostas = new ArrayList();

    public Jogador(String email, String pin, String nome) {
        this.email = email;
        this.nome = nome;
        while (pin.length() != 6) {
            System.out.println("Digite o pin do jogador: (deve possuir 6 digitos)");
            pin = scanner.next();
        }
        this.pin = pin;
    }

    public void addItem(Item i) {
        itens.add(i);
    }

    public void removeItem(int posi) {
        itens.remove(posi);
    }

    public void removeItem(Item i) {
        itens.remove(i);
    }

    public void printItens() {
        int cont = 1;
        for (Item i : itens) {
            System.out.println(cont + ". " + i.toString());
            cont++;
        }
    }

    public Item getItem(int posi) {
        return itens.get(posi);
    }

    public Item getItem(Item item) {
        for (Item i : itens) {
            if (i.equals(item)) {
                return i;
            }
        }
        return null;
    }


    // Método para retornar os itens do jogador - Lucas Simao
    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setPin(String pin) {
        if (pin.length() != 6){
            System.out.println("Digite o pin do jogador: (deve possuir 6 digitos)");
            pin = scanner.next();
            setPin(pin);
        } else {
            this.pin = pin;
        }
    }

    public Proposta getProposta(int posi) {
        return propostas.get(posi);
    }

    public void excluiProp(Proposta proposta) {
        propostas.remove(proposta);
    }

    public void trocaAceita(Proposta proposta) {
        proposta.propAceita(proposta);
        excluiProp(proposta);
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return "Nome: " + nome + "\nEmail: " + email;
    }
}