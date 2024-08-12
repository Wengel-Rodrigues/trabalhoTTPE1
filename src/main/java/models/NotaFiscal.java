package models;

public class NotaFiscal {

  public static void gerarNotaFiscal(Venda venda) {
    imprimirCabecalho(venda);
    double totalItens = venda.calcularValorTotalItens();
    double icms = venda.calcularICMS();
    double impostoMunicipal = venda.calcularImpostoMunicipal();
    double frete = venda.calcularFrete();
    double desconto = venda.calcularDesconto();
    
    imprimirItens(venda);
    imprimirTotais(totalItens, icms, impostoMunicipal, frete, desconto);
    
    double total = calcularTotal(totalItens, icms, impostoMunicipal, frete, desconto);
    imprimirTotalPagar(total);
  }
  
  private static void imprimirCabecalho(Venda venda) {
    System.out.println("Nota Fiscal");
    System.out.println("-----------");
    System.out.println("Data: " + venda.getData());
    System.out.println("Cliente: " + venda.getCliente().getNome());
    System.out.println("Tipo de Cliente: " + venda.getCliente().getTipo());
  }
  
  private static void imprimirItens(Venda venda) {
    System.out.println("Itens:");
    for (ItemVendido item : venda.getItens()) {
        System.out.println("- " + item.getProduto().getDescricao() + ": " + item.getQuantidade() + " x " + item.getValor() + " = " + item.getValorTotal());
    }
  }
  
  private static void imprimirTotais(double totalItens, double icms, double impostoMunicipal, double frete, double desconto) {
    System.out.println("Total dos itens: " + totalItens);
    System.out.println("ICMS: " + icms);
    System.out.println("Imposto Municipal: " + impostoMunicipal);
    System.out.println("Frete: " + frete);
    System.out.println("Desconto: " + desconto);
  }
  
  private static double calcularTotal(double totalItens, double icms, double impostoMunicipal, double frete, double desconto) {
    return totalItens + icms + impostoMunicipal + frete - desconto;
  }
  
  private static void imprimirTotalPagar(double total) {
    System.out.println("Total a pagar: " + total);
  }
}
