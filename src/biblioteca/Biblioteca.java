package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Exemplar> exemplares;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.exemplares = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void addExemplar(Exemplar exemplar) {
        this.exemplares.add(exemplar);
    }
}
