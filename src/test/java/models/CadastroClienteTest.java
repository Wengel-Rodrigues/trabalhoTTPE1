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
    private Endereco endereco;
    private Cliente expectedCliente;
    private boolean usaCartaoEmpresa;

    public CadastroClienteTest(String nome, Endereco endereco, boolean usaCartaoEmpresa, Cliente expectedCliente) {
        this.nome = nome;
        this.endereco = endereco;
        this.usaCartaoEmpresa = usaCartaoEmpresa;
        this.expectedCliente = expectedCliente;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "João", new Endereco("SP", "capital"), false,
                        new ClientePadrao("João", new Endereco("SP", "capital"), false) },
                { "Maria", new Endereco("RJ", "interior"), true,
                        new ClienteEspecial("Maria", new Endereco("RJ", "interior"), true) },
                { "Pedro", new Endereco("DF", "capital"), true,
                        new ClientePrime("Pedro", new Endereco("DF", "capital"), true) }
        });
    }

    @Test
    public void testClienteCreation() {
        Cliente cliente = null;
        if (expectedCliente instanceof ClientePadrao) {
            cliente = new ClientePadrao(nome, endereco, usaCartaoEmpresa);
        } else if (expectedCliente instanceof ClienteEspecial) {
            cliente = new ClienteEspecial(nome, endereco, usaCartaoEmpresa);
        } else if (expectedCliente instanceof ClientePrime) {
            cliente = new ClientePrime(nome, endereco, usaCartaoEmpresa);
        }

        assertEquals(expectedCliente.getNome(), cliente.getNome());
        assertEquals(expectedCliente.getTipo(), cliente.getTipo());
        assertEquals(expectedCliente.getEndereco().getRegiao(), cliente.getEndereco().getRegiao());
        assertEquals(expectedCliente.getEndereco().getLocalidade(), cliente.getEndereco().getLocalidade());
    }
}
