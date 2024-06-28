package models;

public class Endereco {
    private String estado;
    private String localidade; // (capital ou interior)

    public Endereco(String estado, String localidade) {
        this.estado = estado;
        this.localidade = localidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getLocalidade() {
        return localidade;
    }
}