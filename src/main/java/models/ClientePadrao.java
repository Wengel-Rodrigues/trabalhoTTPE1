package models;

public class ClientePadrao extends Cliente {
    public ClientePadrao(String nome, Endereco endereco, boolean usaCartaoEmpresa) {
        super(nome, endereco, usaCartaoEmpresa);
    }

    @Override
    public String getTipo() {
        return "padrão";
    }
}
