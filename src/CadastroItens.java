import java.util.ArrayList;


public class CadastroItens {
    private ArrayList<Item> itens;

    public CadastroItens() {
        this.itens = new ArrayList<>();

    }

    public boolean cadastrarItem(Item item) {
        if (itens.contains(item)) {
            return false;
        } else
            itens.add(item);
        return true;
    }

    public ArrayList<Item> getItens() { return itens; }

}