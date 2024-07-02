package models;

import java.util.HashMap;
import java.util.Map;

public class CashbackManager {
    private static Map<ClientePrime, Double> cashbackSaldo = new HashMap<>();

    public static double calcularCashback(Venda venda) {
        if (venda.getCliente() instanceof ClientePrime) {
            double valorTotalItens = venda.calcularValorTotalItens();
            double cashbackRate = venda.getCliente().usaCartaoEmpresa() ? 0.05 : 0.03;
            double cashback = valorTotalItens * cashbackRate;
            adicionarCashback((ClientePrime) venda.getCliente(), cashback);
            return cashback;
        }
        return 0.0;
    }

    public static void adicionarCashback(ClientePrime cliente, double valor) {
        cashbackSaldo.put(cliente, cashbackSaldo.getOrDefault(cliente, 0.0) + valor);
    }

    public static double getCashbackSaldo(ClientePrime cliente) {
        return cashbackSaldo.getOrDefault(cliente, 0.0);
    }

    public static void usarCashback(ClientePrime cliente, double valor) {
        double saldoAtual = getCashbackSaldo(cliente);
        if (saldoAtual >= valor) {
            cashbackSaldo.put(cliente, saldoAtual - valor);
        } else {
            throw new IllegalArgumentException("Saldo de cashback insuficiente.");
        }
    }
}
