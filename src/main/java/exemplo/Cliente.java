package exemplo;

import org.zoodb.api.impl.ZooPC;

public class Cliente extends ZooPC{

    private String nome;

    public Cliente() {
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        zooActivateRead();
        return nome;
    }

    public void setNome(String nome) {
        zooActivateWrite();
        this.nome = nome;
    }

    @Override
    public String toString() {
        zooActivateRead();
        return "Cliente{" + "nome=" + nome + '}';
    }
    
}
