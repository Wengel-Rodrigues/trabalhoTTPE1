package models;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CadastroClienteTest {
    private String nome;
    private String tipo;
    private Endereco endereco;
    private Cliente expectedCliente;
    private boolean usaCartaoEmpresa; 

    public CadastroClienteTest(String nome, String tipo, Endereco endereco, Cliente expectedCliente, boolean usaCartaoEmpresa) {
        this.nome = nome;
        this.tipo = tipo;
        this.endereco = endereco;
        this.expectedCliente = expectedCliente;
        this.usaCartaoEmpresa = usaCartaoEmpresa; 
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "João", "padrão", new Endereco("SP", "capital"),
                        new ClientePadrao("João", new Endereco("SP", "capital"), false) },
                { "Maria", "especial", new Endereco("RJ", "interior"),
                        new ClienteEspecial("Maria", new Endereco("RJ", "interior"), true) },
                { "Pedro", "prime", new Endereco("DF", "capital"),
                        new ClientePrime("Pedro", new Endereco("DF", "capital"), true) }
        });
    }

    @Test
    public void testClienteCreation() {
        Cliente cliente = null;
        if ("padrão".equals(tipo)) {
            cliente = new ClientePadrao(nome, endereco, usaCartaoEmpresa); 
        } else if ("especial".equals(tipo)) {
            cliente = new ClienteEspecial(nome, endereco, usaCartaoEmpresa);
        } else if ("prime".equals(tipo)) {
            cliente = new ClientePrime(nome, endereco, usaCartaoEmpresa); 
        }

        assertEquals(expectedCliente.getNome(), cliente.getNome());
        assertEquals(expectedCliente.getTipo(), cliente.getTipo());
        assertEquals(expectedCliente.getEndereco().getRegiao(), cliente.getEndereco().getRegiao());
        assertEquals(expectedCliente.getEndereco().getLocalidade(), cliente.getEndereco().getLocalidade());
    }
}
