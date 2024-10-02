import java.util.ArrayList;


public class CadastroItens {
    private ArrayList<Item> itens;

    public CadastroItens() {
        itens = new ArrayList<>();

    }

    public Item cadastrarItem(Item item) {
        if (itens.contains(item)) {
            return null;
        } else
            itens.add(item);
        return item;
    }
}