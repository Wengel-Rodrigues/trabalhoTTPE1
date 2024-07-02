package models;
public class ItemVendido {
    private Produto produto;
    private int quantidade;
    private double valor;
    private double total; 

    public ItemVendido(Produto produto, int quantidade, double valor, double total) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.total = total;
    }

    // Métodos getters e setters
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorTotal() {
        return total;
    }

    public double setValorTotal() {
        return total;
    }
}
