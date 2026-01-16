package biblioteca;

import java.time.LocalDate;

public class Emprestimo {
    private LocalDate dataRetirada;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private Exemplar exemplar;
    private Usuario usuario;
    private String status;

    public Emprestimo(Usuario usuario, Exemplar exemplar) {
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.dataRetirada = LocalDate.now();
        this.dataDevolucaoPrevista = LocalDate.now().plusDays(7);
        this.status = "ATIVO";
    }

    public void devolver() {
        this.dataDevolucaoReal = LocalDate.now();
        this.status = "FINALIZADO";
        this.exemplar.setDisponivel(true);
    }

    public Exemplar getExemplar() {
        return exemplar;
    }
    
    public String getStatus() {
        return status;
    }
    
    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return String.format("Livro: %s | Retirado: %s | Status: %s", 
            exemplar.getLivro().getTitulo(), dataRetirada, status);
    }
}