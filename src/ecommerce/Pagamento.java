package ecommerce;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Pagamento {
    private double valor;
    private ZonedDateTime dataPagamento;
    private ZonedDateTime dataCriacao;

    protected Pagamento(double valor) {
        this.valor = valor;
        this.dataCriacao = ZonedDateTime.now();
        this.dataPagamento = null;
    }

    public double getValor() {
        return valor;
    }

    public ZonedDateTime getDataPagamento() {
        return dataPagamento;
    }

    public ZonedDateTime getDataCriacao() {
        return dataCriacao;
    }

    protected void setDataPagamento(ZonedDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public abstract boolean processar();

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "%s, efetuado em %s".formatted(this.getClass().getSimpleName(), 
        dataPagamento.format(formatter));
    }
}