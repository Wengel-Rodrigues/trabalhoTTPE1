package models;
import java.time.LocalDate;
import java.util.List;

public class Venda {
    private LocalDate data;
    private Cliente cliente;
    private List<ItemVendido> itens;
    private String metodoPagamento;
    private CalculadoraVenda calculadora;

    // Refatoração: Agora, em vez de a classe Venda fazer todos os cálculos por conta própria,
    // a responsabilidade foi passada para uma nova classe chamada CalculadoraVenda.

    public Venda(LocalDate data, Cliente cliente, List<ItemVendido> itens, String metodoPagamento) {
        this.data = data;
        this.cliente = cliente;
        this.itens = itens;
        this.metodoPagamento = metodoPagamento;
        this.calculadora = new CalculadoraVenda(this);
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

    // Refatoração: Os métodos abaixo foram movidos para a CalculadoraVenda,
    // deixando a classe Venda mais simples. Agora, a Venda só chama esses métodos
    // através da CalculadoraVenda, que é responsável por fazer os cálculos.

   // Refatoração: Substituir método por objeto-método para o cálculo de frete.
    public double calcularFrete() {
        CalculadoraFrete calculadoraFrete = new CalculadoraFrete(cliente.getEndereco());
        return calculadoraFrete.calcular();
    }

    public double calcularDesconto() {
        return calculadora.calcularDesconto();
    }

    public double calcularICMS() {
        return calculadora.calcularICMS();
    }

    public double calcularImpostoMunicipal() {
        return calculadora.calcularImpostoMunicipal();
    }

    public double calcularValorTotalItens() {
        return calculadora.calcularValorTotalItens();
    }

    public static double calcularVendasUltimoMes(List<Venda> vendas, Cliente cliente) {
        LocalDate hoje = LocalDate.now();
        LocalDate umMesAtras = hoje.minusMonths(1);
        double total = 0.0;

        for (Venda venda : vendas) {
            if (venda.getCliente().equals(cliente) && 
                (venda.getData().isAfter(umMesAtras) || venda.getData().isEqual(umMesAtras)) &&
                (venda.getData().isBefore(hoje) || venda.getData().isEqual(hoje))) {
                total += venda.calcularValorTotalItens();
            }
        }
        return total;
    }
        
}