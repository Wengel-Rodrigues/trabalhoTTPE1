package models;

public class NotaFiscal {

  public static void gerarNotaFiscal(Venda venda) {
    System.out.println("Nota Fiscal");
    System.out.println("-----------");
    System.out.println("Data: " + venda.getData());
    System.out.println("Cliente: " + venda.getCliente().getNome());
    System.out.println("Tipo de Cliente: " + venda.getCliente().getTipo());

    double totalItens = venda.calcularValorTotalItens();
    double icms = venda.calcularICMS();
    double impostoMunicipal = venda.calcularImpostoMunicipal();
    double frete = venda.calcularFrete();
    double desconto = venda.calcularDesconto();

    System.out.println("Itens:");
    for (ItemVendido item : venda.getItens()) {
        System.out.println("- " + item.getProduto().getDescricao() + ": " + item.getQuantidade() + " x " + item.getValor() + " = " + item.getValorTotal());
    }

    System.out.println("Total dos itens: " + totalItens);
    System.out.println("ICMS: " + icms);
    System.out.println("Imposto Municipal: " + impostoMunicipal);
    System.out.println("Frete: " + frete);
    System.out.println("Desconto: " + desconto);

    double total = totalItens + icms + impostoMunicipal + frete - desconto;
    System.out.println("Total a pagar: " + total);
  }
}
