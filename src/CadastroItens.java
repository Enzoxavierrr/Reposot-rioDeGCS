import java.util.ArrayList;


public class CadastroItens {
    private ArrayList<Item> itens;
    ArrayList<Item> itensOrdenadosPeloValor;


    public CadastroItens() {
        this.itens = new ArrayList<>();
        this.itensOrdenadosPeloValor = new ArrayList<>(itens);

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
}