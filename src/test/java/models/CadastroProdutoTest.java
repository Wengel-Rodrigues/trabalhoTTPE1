package models;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CadastroProdutoTest {
    private String codigo;
    private String descricao;
    private double valor;
    private String unidade;
    private Produto expectedProduto;

    public CadastroProdutoTest(String codigo, String descricao, double valor, String unidade, Produto expectedProduto) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.unidade = unidade;
        this.expectedProduto = expectedProduto;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "001", "Coca-Cola 2L", 10.0, "unidade", new Produto("001", "Coca-Cola 2L", 10.0, "unidade") },
                { "002", "Papel Sulfite A4 500 folhas", 20.0, "pacote", new Produto("002", "Papel Sulfite A4 500 folhas", 20.0, "pacote") }
        });
    }

    @Test
    public void testProdutoCreation() {
        Produto produto = new Produto(codigo, descricao, valor, unidade);
        assertEquals(expectedProduto.getCodigo(), produto.getCodigo());
        assertEquals(expectedProduto.getDescricao(), produto.getDescricao());
        assertEquals(expectedProduto.getValor(), produto.getValor(), 0.01);
        assertEquals(expectedProduto.getUnidade(), produto.getUnidade());
    }
}
