package models;
import java.util.List;

public class CalculadoraVenda {
    private Venda venda;

    // Refatoração: Criamos essa classe para cuidar de todos os cálculos que antes estavam na classe Venda.
    // Isso deixa o código mais organizado e fácil de entender, já que a Venda não precisa se preocupar
    // com tantos detalhes. Agora, essa classe CalculadoraVenda é que faz todo o trabalho pesado.

    public CalculadoraVenda(Venda venda) {
        this.venda = venda;
    }

    public double calcularDesconto() {
        double valorTotalItens = calcularValorTotalItens();
        double desconto = 0.0;

        if (venda.getCliente() instanceof ClienteEspecial) {
            desconto += valorTotalItens * 0.10; // Desconto de 10% para clientes especiais

            if (venda.getCliente().usaCartaoEmpresa()) {
                desconto += valorTotalItens * 0.10; // Desconto adicional de 10% com cartão da empresa
            }
        }

        if (venda.getCliente() instanceof ClientePrime) {
            // Nenhum frete para clientes prime
            // Cashback de R$0,03 a cada real gasto
            double cashbackRate = venda.getCliente().usaCartaoEmpresa() ? 0.05 : 0.03;
            double cashback = valorTotalItens * cashbackRate;
            desconto += cashback;
        }

        return desconto;
    }

    public double calcularICMS() {
        double icmsRate = venda.getCliente().getEndereco().getRegiao().equalsIgnoreCase("DF") ? 0.18 : 0.12;
        double valorTotalItens = calcularValorTotalItens();
        return valorTotalItens * icmsRate;
    }

    public double calcularImpostoMunicipal() {
        double impostoMunicipalRate = venda.getCliente().getEndereco().getRegiao().equalsIgnoreCase("DF") ? 0.0 : 0.04;
        double valorTotalItens = calcularValorTotalItens();
        return valorTotalItens * impostoMunicipalRate;
    }

    public double calcularValorTotalItens() {
        double total = 0.0;
        for (ItemVendido item : venda.getItens()) {
            total += item.getValorTotal();
        }
        return total;
    }
}
