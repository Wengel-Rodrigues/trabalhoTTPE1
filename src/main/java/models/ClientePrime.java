package models;

public class ClientePrime extends Cliente {

    public ClientePrime(String nome, Endereco endereco, boolean usaCartaoEmpresa) {
        super(nome, endereco, usaCartaoEmpresa);

    }

    @Override
    public String getTipo() {
        return "prime";
    }

}


