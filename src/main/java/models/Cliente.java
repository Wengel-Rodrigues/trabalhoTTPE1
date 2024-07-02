package models;

public abstract class Cliente {
    private String nome;
    private Endereco endereco;
    private boolean usaCartaoEmpresa; 

    public Cliente(String nome, Endereco endereco, boolean usaCartaoEmpresa) {
        this.nome = nome;
        this.endereco = endereco;
        this.usaCartaoEmpresa = usaCartaoEmpresa; 
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public abstract String getTipo();

    public boolean usaCartaoEmpresa() {
        return usaCartaoEmpresa;
    }
}
