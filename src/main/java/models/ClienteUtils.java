package models;

import java.util.List;

public class ClienteUtils {
  public static boolean isClienteEspecial(List<Venda> vendas, Cliente cliente) {
    double valorVendasUltimoMes = Venda.calcularVendasUltimoMes(vendas, cliente);
    return valorVendasUltimoMes > 100.0;
  }

  public static boolean isCartaoEmpresa(String numeroCartao) {
    return numeroCartao.startsWith("4296 13");
  }
}
