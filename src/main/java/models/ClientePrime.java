package models;

public class ClientePrime extends Cliente {
    public ClientePrime(String nome, Endereco endereco) {
        super(nome, endereco);
    }

    @Override
    public String getTipo() {
        return "prime";
    }
}


