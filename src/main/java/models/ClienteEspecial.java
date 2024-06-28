package models;

public class ClienteEspecial extends Cliente {
    public ClienteEspecial(String nome, Endereco endereco) {
        super(nome, endereco);
    }

    @Override
    public String getTipo() {
        return "especial";
    }
}

