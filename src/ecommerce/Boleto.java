package ecommerce;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Boleto extends Pagamento{
    private String linhaDigitavel;
    private LocalDate dataVencimento;

    public Boleto(double valor) {
        super(valor);
        this.linhaDigitavel = UUID.randomUUID().toString();
        this.dataVencimento = LocalDate.now().plusDays(5);
    }

    public String getLinhaDigitavel() {
        return linhaDigitavel;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    @Override
    public boolean processar() {
        LocalDate hoje = LocalDate.now();
        
        if (hoje.isAfter(this.dataVencimento)) {
            System.out.println("Erro: Boleto vencido em " + this.dataVencimento);
            return false;
        }
        
        this.setDataPagamento(ZonedDateTime.now());
        System.out.println("Pagamento realizado...");
        return true;
    }

}
