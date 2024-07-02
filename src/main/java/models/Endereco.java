package models;

public class Endereco {
    private String regiao;
    private String localidade; // (capital ou interior)

    public Endereco(String regiao, String localidade) {
        this.regiao = regiao;
        this.localidade = localidade;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getLocalidade() {
        return localidade;
    }
}