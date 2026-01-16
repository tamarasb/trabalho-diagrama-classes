package ecommerce;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {
    private String codigo;
    private ZonedDateTime dataCompra;
    private String status;
    private Cliente cliente;
    private Pagamento pagamento;
    private List<ItemPedido> itens;

    public Pedido(Cliente cliente) {
        this.codigo = UUID.randomUUID().toString();
        this.dataCompra = ZonedDateTime.now();
        this.status = "ATIVO";
        this.cliente = cliente;
        this.pagamento = null;
        this.itens = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public ZonedDateTime getDataCompra() {
        return dataCompra;
    }

    public String getStatus() {
        return status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void addItem(Produto produto, int quantidade){
        this.itens.add(new ItemPedido(produto, quantidade));
    }

    public void removeItem(Produto produto){
        this.itens.removeIf(item -> item.getProduto().equals(produto));
    }

    public double calculaValorTotal(){
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    @SuppressWarnings("java:S106")
    public void finalizarPedido(Pagamento pagamento){
        this.pagamento = pagamento;

        boolean sucesso = this.pagamento.processar();

        if(sucesso){
            this.status = "CONCLUÍDO";

            for (ItemPedido item : itens) {
                item.getProduto().baixarEstoque(item.getQuantidade());
            }

            System.out.println("Pedido finalizado com sucesso!");
        }else {
            this.status = "AGUARDANDO_PAGAMENTO";
            System.out.println("Falha no pagamento. Pedido não finalizado.");
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        StringBuilder resumoPedido = new StringBuilder();
        resumoPedido.append(String.format("""
            ID: %-10s\tCriado em: %s [%s]

            Pagamento:
                %s

            Itens comprados:%s
        """, codigo, dataCompra.format(formatter), status, pagamento
        ));
        
        for (ItemPedido itemPedido : itens) {
            resumoPedido.append("\t");
            resumoPedido.append(itemPedido);
            resumoPedido.append("\n");
        }
        resumoPedido.append("\n");
        resumoPedido.append("  Valor total: R$ %.2f".formatted(calculaValorTotal()));
        return resumoPedido.toString();
    }
}