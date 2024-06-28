package models;

public class ClientePadrao extends Cliente {
    public ClientePadrao(String nome, Endereco endereco) {
        super(nome, endereco);
    }

    @Override
    public String getTipo() {
        return "padrão";
    }
}
