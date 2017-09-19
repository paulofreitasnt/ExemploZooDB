
import java.util.ArrayList;
import java.util.List;
import org.zoodb.api.impl.ZooPC;

public class Pessoa extends ZooPC {

    private String nome;
    private int idade;
    private final List<Pessoa> amigos;

    public Pessoa() {
        amigos = new ArrayList<>();
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        amigos = new ArrayList<>();
    }

    public String getNome() {
        zooActivateRead();
        return nome;
    }

    public void setNome(String nome) {
        zooActivateWrite();
        this.nome = nome;
    }

    public int getIdade() {
        zooActivateRead();
        return idade;
    }

    public void setIdade(int idade) {
        zooActivateWrite();
        this.idade = idade;
    }

    public boolean addAmigo(Pessoa p) {
        zooActivateWrite();
        return amigos.add(p);
    }

    public List<Pessoa> getAmigos() {
        zooActivateRead();
        return amigos;
    }

    @Override
    public String toString() {
        zooActivateRead();
        return "Pessoa{" + "nome=" + nome + ", idade=" + idade + ", amigos=" + amigos + '}';
    }

}
