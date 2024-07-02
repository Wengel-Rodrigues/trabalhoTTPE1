package models;

public class ClienteEspecial extends Cliente {

    public ClienteEspecial(String nome, Endereco endereco, boolean usaCartaoEmpresa) {
        super(nome, endereco, usaCartaoEmpresa);
    }

    @Override
    public String getTipo() {
        return "especial";
    }

}