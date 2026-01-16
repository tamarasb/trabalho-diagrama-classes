package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private List<Emprestimo> emprestimos;
    private List<Reserva> reservas;

    public Usuario(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.emprestimos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void realizarEmprestimo(Exemplar exemplar) {
        if (exemplar.isDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(this, exemplar);
            this.emprestimos.add(emprestimo);
            exemplar.setDisponivel(false);
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Exemplar indisponível.");
        }
    }

    public void realizarReserva(Livro livro) {
        Reserva reserva = new Reserva(livro, this);
        this.reservas.add(reserva);
        System.out.println("Livro " + livro.getTitulo() + " reservado.");
    }
}
