package models;
import java.time.LocalDate;
import java.util.List;

public class Venda {
    private LocalDate data;
    private Cliente cliente;
    private List<ItemVendido> itens;
    private String metodoPagamento;

    public Venda(LocalDate data, Cliente cliente, List<ItemVendido> itens, String metodoPagamento) {
        this.data = data;
        this.cliente = cliente;
        this.itens = itens;
        this.metodoPagamento = metodoPagamento;
    }

    // Métodos getters e setters
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVendido> getItens() {
        return itens;
    }

    public void setItens(List<ItemVendido> itens) {
        this.itens = itens;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    // Métodos para cálculo de frete, descontos e impostos
    public double calcularFrete() {
        Endereco enderecoCliente = cliente.getEndereco();
        String localidade = enderecoCliente.getLocalidade();
        String regiao = enderecoCliente.getRegiao();

        // Tabela de valores de frete
        double freteCapitalDF = 5.0;
        double freteInteriorDF = 0.0;
        double freteCapitalCO = 10.0;
        double freteInteriorCO = 13.0;
        double freteCapitalNO = 15.0;
        double freteInteriorNO = 18.0;
        double freteCapitalN = 20.0;
        double freteInteriorN = 25.0;
        double freteCapitalSE = 7.0;
        double freteInteriorSE = 10.0;
        double freteCapitalS = 10.0;
        double freteInteriorS = 13.0;
    

        if (localidade.equalsIgnoreCase("capital") && regiao.equalsIgnoreCase("DF")) {
            return freteCapitalDF;
        } else if (localidade.equalsIgnoreCase("interior") && regiao.equalsIgnoreCase("DF")) {
            return freteInteriorDF;
        } else if (localidade.equalsIgnoreCase("capital") && regiao.equalsIgnoreCase("CO")){
            return freteCapitalCO;
        } else if (localidade.equalsIgnoreCase("interior") && regiao.equalsIgnoreCase("CO")){
            return freteInteriorCO;
        } else if (localidade.equalsIgnoreCase("capital") && regiao.equalsIgnoreCase("NO")){
            return freteCapitalNO;
        } else if (localidade.equalsIgnoreCase("interior") && regiao.equalsIgnoreCase("NO")){
            return freteInteriorNO;
        } else if (localidade.equalsIgnoreCase("capital") && regiao.equalsIgnoreCase("N")){
            return freteCapitalN;
        } else if (localidade.equalsIgnoreCase("interior") && regiao.equalsIgnoreCase("N")){
            return freteInteriorN;
        } else if (localidade.equalsIgnoreCase("capital") && regiao.equalsIgnoreCase("SE")){
            return freteCapitalSE;
        } else if (localidade.equalsIgnoreCase("interior") && regiao.equalsIgnoreCase("SE")){
            return freteInteriorSE;
        } else if (localidade.equalsIgnoreCase("capital") && regiao.equalsIgnoreCase("S")){
            return freteCapitalS;
        } else if (localidade.equalsIgnoreCase("interior") && regiao.equalsIgnoreCase("S")){
            return freteInteriorS;
        } else {
            return 0.0;
        }

    }

    public double calcularDesconto() {
        double valorTotalItens = calcularValorTotalItens();
        double desconto = 0.0;

        if (cliente instanceof ClienteEspecial) {
            desconto += valorTotalItens * 0.10; // Desconto de 10% para clientes especiais

            if (cliente.usaCartaoEmpresa()) {
                desconto += valorTotalItens * 0.10; // Desconto adicional de 10% com cartão da empresa
            }
        }

        if (cliente instanceof ClientePrime) {
            // Nenhum frete para clientes prime
            // Cashback de R$0,03 a cada real gasto
            double cashbackRate = cliente.usaCartaoEmpresa() ? 0.05 : 0.03;
            double cashback = valorTotalItens * cashbackRate;
            desconto += cashback;
        }

        return desconto;
    }

    public double calcularICMS() {
        double icmsRate = cliente.getEndereco().getRegiao().equalsIgnoreCase("DF") ? 0.18 : 0.12;
        double valorTotalItens = calcularValorTotalItens();
        return valorTotalItens * icmsRate;
    }

    public double calcularImpostoMunicipal() {
        double impostoMunicipalRate = cliente.getEndereco().getRegiao().equalsIgnoreCase("DF") ? 0.0 : 0.04;
        double valorTotalItens = calcularValorTotalItens();
        return valorTotalItens * impostoMunicipalRate;
    }

    private double calcularValorTotalItens() {
        double total = 0.0;
        for (ItemVendido item : itens) {
            total += item.getValorTotal();
        }
        return total;
    }
        
}