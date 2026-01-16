package ecommerce;

import java.util.Objects;

public class Produto {
    private String codigo;
    private String nome;
    private int estoque;
    private double preco;
    
    public Produto(String codigo, String nome, int estoque, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean verificarEstoque(int quantidade){
        return (this.estoque >= quantidade);
    }

    public void reporEstoque(int quantidade) {
        this.estoque += quantidade;
    }

    public void baixarEstoque(int quantidade){
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser positiva.");
        }
        if (!verificarEstoque(quantidade)) {
            throw new IllegalArgumentException("Estoque insuficiente para o produto: " + this.nome);
        }
        this.estoque -= quantidade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(codigo, produto.codigo);
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-30s | R$ %.2f", codigo, nome, preco);
    }
}
