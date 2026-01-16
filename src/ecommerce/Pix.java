package ecommerce;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Pix extends Pagamento{
    private String codigoCopiaCola;
    private String chavePix;

    public Pix(double valor) {
        super(valor);
        this.codigoCopiaCola = UUID.randomUUID().toString();
        this.chavePix = UUID.randomUUID().toString();
    }

    public String getCodigoCopiaCola() {
        return codigoCopiaCola;
    }

    public String getChavePix() {
        return chavePix;
    }

    @Override
    public boolean processar() {
        this.setDataPagamento(ZonedDateTime.now());
        System.out.println("Pagamento de R$ " + getValor() + " realizado com sucesso em " 
             + this.getDataPagamento().format(DateTimeFormatter.RFC_1123_DATE_TIME)+".");
        return true;
    }
}
