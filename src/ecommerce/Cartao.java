package ecommerce;

import java.time.ZonedDateTime;

public class Cartao extends Pagamento{
    private String numeroCartao;
    private String nomeTitular;
    private String cvv;

    public Cartao(double valor, String numeroCartao, String nomeTitular, String cvv) {
        super(valor);
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.cvv = cvv;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public boolean processar() {
        if (this.numeroCartao != null && !this.numeroCartao.isEmpty()) {
            this.setDataPagamento(ZonedDateTime.now());
            System.out.println("Conectando com a operadora do cartão...");
            System.out.println("Pagamento de R$ " + getValor() + " aprovado no cartão final " 
                + this.numeroCartao.substring(Math.max(0, this.numeroCartao.length() - 4)));
            return true;
        } else {
            System.out.println("Erro: Cartão inválido.");
            return false;
        }
    }
}
