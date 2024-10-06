import java.util.ArrayList;


public class CadastroItens {
    private static ArrayList<Item> itens;
    ArrayList<Item> itensOrdenadosPeloValor;


    public CadastroItens() {

        this.itens = new ArrayList<>();
        this.itensOrdenadosPeloValor = new ArrayList<>(itens);

    }

    public void addItem(Item i) {
        itens.add(i);
    }

    public void removeItem(Item i) {
        itens.remove(i);
    }

    public void printItens(Jogador j) {
        int cont = 1;
        for (Item i : itens) {
            if (j.getItem(cont-1) != i) {
                System.out.println(cont + ". " + i.toString());
                cont++;
            }
        }
    }

    public void printItens(String tipo) {
        int cont = 1;
        for (Item i : itens) {
            if (tipo.equals(i.getTipo())) {
                System.out.println(cont + ". " + i.toString());
                cont++;
            }
        }
    }

    public Item searchItens(String nomeItem) {
        for (Item i : itens) {
            if (nomeItem.equals(i.getNome())) {
                return i;
            }
        } return null;
    }

    public Item cartaMaisPC() {
        Item maisPC = itens.get(0);
        for (Item i : itens) {
            if (i.getPC() > maisPC.getPC()) {
                maisPC = i;
            }
        }
        return maisPC;
    }

    public boolean cadastrarItem(Item item) {
        if (itens.contains(item)) {
            return false;
        } else
            itens.add(item);
        return true;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public ArrayList<Item> listarItemsPorValor() {
        int tamanhoArrayDosValores = itensOrdenadosPeloValor.size();


        return itensOrdenadosPeloValor;
    }
    public void printAllItens(){
        for (Item i : itens){
            System.out.println(i.getDono()+" : "+i.getNome()+" : "+i.getValor());
        }
    }
}