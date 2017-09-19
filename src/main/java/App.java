
import exemplo.Cliente;
import exemplo.ItemPedido;
import exemplo.Pedido;
import exemplo.Produto;
import java.util.Collection;
import java.util.List;
import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;
import org.zoodb.jdo.ZooJdoHelper;

public class App {

    public static void main(String[] args) {

        Cliente c = new Cliente("João");
        Produto prod1 = new Produto(1, "Arroz", 3);
        Produto prod2 = new Produto(2, "Feijão", 5);
        Pedido p = new Pedido(c);
        p.addItem(new ItemPedido(1, prod1, 2));
        p.addItem(new ItemPedido(2, prod2, 1));

        String path = "Supermercado.zdb";
        if (!ZooJdoHelper.dbExists(path)) {
            ZooJdoHelper.createDb(path);
        }

        PersistenceManager pm = ZooJdoHelper.openDB(path);
        
//        pm.currentTransaction().begin();
//        pm.makePersistent(p);
//        pm.currentTransaction().commit();
        
        pm.currentTransaction().begin();
        
        Extent<Pedido> pedidos = pm.getExtent(Pedido.class);
        
        for(Pedido ped : pedidos){
            System.out.println(ped);
        }

        if(pm.currentTransaction().isActive()){
            pm.currentTransaction().rollback();
        }
        
        pm.close();
        pm.getPersistenceManagerFactory().close();
        
    }

}
