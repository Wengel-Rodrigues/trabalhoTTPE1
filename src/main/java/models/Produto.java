package models;

public class Produto {
    private String codigo;
    private String descricao;
    private double valor;
    private String unidade;

    public Produto(String codigo, String descricao, double valor, String unidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.unidade = unidade;
    }

    public String getCodigo() {
        return codigo;
    }
   
    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getUnidade() {
        return unidade;
    }

}