package exemplo;

import java.util.ArrayList;
import java.util.List;
import org.zoodb.api.impl.ZooPC;

public class Pedido extends ZooPC {

    private Cliente cliente;
    private List<ItemPedido> itens;

    public Pedido() {
        itens = new ArrayList<>();
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        itens = new ArrayList<>();
    }

    public Cliente getCliente() {
        zooActivateRead();
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        zooActivateWrite();
        this.cliente = cliente;
    }
    
    public List<ItemPedido> getItens(){
        zooActivateRead();
        return itens;
    }
    
    public boolean addItem(ItemPedido item){
        zooActivateWrite();
        return itens.add(item);
    }

    @Override
    public String toString() {
        zooActivateRead();
        return "Pedido{" + "cliente=" + cliente + ", itens=" + itens + '}';
    }
    
    public float calcularTotal(){
        zooActivateRead();
        float total = 0;
        for(ItemPedido item : itens){
            total += item.calcularSubtotal();
        }
        return total;
    }
    
}
