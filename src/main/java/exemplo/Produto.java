package exemplo;

import org.zoodb.api.impl.ZooPC;

public class Produto extends ZooPC{

    private int id;
    private String descricao;
    private float preco;

    public Produto() {
    }

    public Produto(int id, String descricao, float preco) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getId() {
        zooActivateRead();
        return id;
    }

    public void setId(int id) {
        zooActivateWrite();
        this.id = id;
    }

    public String getDescricao() {
        zooActivateRead();
        return descricao;
    }

    public void setDescricao(String descricao) {
        zooActivateWrite();
        this.descricao = descricao;
    }

    public float getPreco() {
        zooActivateRead();
        return preco;
    }

    public void setPreco(float preco) {
        zooActivateWrite();
        this.preco = preco;
    }

    @Override
    public String toString() {
        zooActivateRead();
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", preco=" + preco + '}';
    }
    
}
