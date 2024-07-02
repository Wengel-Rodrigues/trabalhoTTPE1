package models;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class VendaTest {

    @Test
    public void testCalcularFrete() {
        // Cenário: Cliente no interior do Distrito Federal
        Cliente cliente = new ClientePadrao("João", new Endereco("DF", "capital"), false);
        Produto produto = new Produto("P123", "Camiseta", 50.0, "unidade");
        ItemVendido item = new ItemVendido(produto, 2, 50.0, 50.0); // Valor total: 100.0
        List<ItemVendido> itens = new ArrayList<>(); // Crie uma lista de itens
        itens.add(item); // Adicione o item à lista
        Venda venda = new Venda(LocalDate.now(), cliente, itens, "cartão");

        // Execução
        double frete = venda.calcularFrete();

        // Verificação
        assertEquals(5.0, frete, 0.01); // Valor esperado para interior do DF
    }

    @Test
    public void testCalcularImpostos() {
        // Cenário: Cliente no Distrito Federal
        Cliente cliente = new ClientePadrao("Maria", new Endereco("DF", "capital"), false);
        Produto produto = new Produto("P456", "Calça Jeans", 120.0, "unidade");
        ItemVendido item = new ItemVendido(produto, 1, 120.0, 120.0); // Valor total: 120.0
        List<ItemVendido> itens = new ArrayList<>();
        itens.add(item);
        Venda venda = new Venda(LocalDate.now(), cliente, itens, "cartão");

        // Execução
        double icms = venda.calcularICMS();
        double impostoMunicipal = venda.calcularImpostoMunicipal();

        // Verificação
        assertEquals(21.6, icms, 0.01); // Valor esperado para ICMS no DF
        assertEquals(0.0, impostoMunicipal, 0.01); // Valor esperado para imposto municipal no DF
    }
    @Test
    public void testAplicarDescontos() {
        // Cenário: Cliente com desconto especial
        Cliente cliente = new ClienteEspecial("Ana", new Endereco("SE", "capital"), false);
        Produto produto = new Produto("P789", "Sapato", 200.0, "par");
        ItemVendido item = new ItemVendido(produto, 1, 200.0, 200.0); // Valor total: 200.0
        List<ItemVendido> itens = new ArrayList<>();
        itens.add(item);
        Venda venda = new Venda(LocalDate.now(), cliente, itens, "dinheiro");

        // Aplicar desconto de 10% ou seja 20 reais
        double valorDesconto = venda.calcularDesconto();

        // Verificação
        assertEquals(20.0, valorDesconto, 0.01); // Valor esperado com desconto de 10%
    }
}
