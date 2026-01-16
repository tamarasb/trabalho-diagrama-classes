package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String isbn;
    private String ano;
    private String descricao;
    private List <Autor> autores;
    private Editora editora;

    public Livro(String titulo, String isbn, String ano, String descricao, Editora editora) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.ano = ano;
        this.descricao = descricao;
        this.editora = editora;
        this.autores = new ArrayList<>();
    }

    public void addAutor(Autor autor) {
        this.autores.add(autor);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public List<Autor> getAutores() {
        return autores;
    }
}
