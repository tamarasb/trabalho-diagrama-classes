package biblioteca;

import java.time.LocalDate;

public class Reserva {
    private LocalDate dataSolicitacao;
    private LocalDate dataExpiracao;
    private Livro livro;
    private Usuario usuario;

    public Reserva(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataSolicitacao = LocalDate.now();
        this.dataExpiracao = LocalDate.now().plusDays(3);
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
