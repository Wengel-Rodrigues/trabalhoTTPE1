package models;

public class CalculadoraFrete {
    private Endereco enderecoCliente;

    public CalculadoraFrete(Endereco enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public double calcular() {
        String localidade = enderecoCliente.getLocalidade();
        String regiao = enderecoCliente.getRegiao();

        // Tabela de valores de frete
        double freteCapitalDF = 5.0;
        double freteInteriorDF = 0.0;
        double freteCapitalCO = 10.0;
        double freteInteriorCO = 13.0;
        double freteCapitalNO = 15.0;
        double freteInteriorNO = 18.0;
        double freteCapitalN = 20.0;
        double freteInteriorN = 25.0;
        double freteCapitalSE = 7.0;
        double freteInteriorSE = 10.0;
        double freteCapitalS = 10.0;
        double freteInteriorS = 13.0;

        if (localidade.equalsIgnoreCase("capital") && regiao.equalsIgnoreCase("DF")) {
            return freteCapitalDF;
        } else if (localidade.equalsIgnoreCase("interior") && regiao.equalsIgnoreCase("DF")) {
            return freteInteriorDF;
        } else if (localidade.equalsIgnoreCase("capital") && regiao.equalsIgnoreCase("CO")) {
            return freteCapitalCO;
        } else if (localidade.equalsIgnoreCase("interior") && regiao.equalsIgnoreCase("CO")) {
            return freteInteriorCO;
        } else if (localidade.equalsIgnoreCase("capital") && regiao.equalsIgnoreCase("NO")) {
            return freteCapitalNO;
        } else if (localidade.equalsIgnoreCase("interior") && regiao.equalsIgnoreCase("NO")) {
            return freteInteriorNO;
        } else if (localidade.equalsIgnoreCase("capital") && regiao.equalsIgnoreCase("N")) {
            return freteCapitalN;
        } else if (localidade.equalsIgnoreCase("interior") && regiao.equalsIgnoreCase("N")) {
            return freteInteriorN;
        } else if (localidade.equalsIgnoreCase("capital") && regiao.equalsIgnoreCase("SE")) {
            return freteCapitalSE;
        } else if (localidade.equalsIgnoreCase("interior") && regiao.equalsIgnoreCase("SE")) {
            return freteInteriorSE;
        } else if (localidade.equalsIgnoreCase("capital") && regiao.equalsIgnoreCase("S")) {
            return freteCapitalS;
        } else if (localidade.equalsIgnoreCase("interior") && regiao.equalsIgnoreCase("S")) {
            return freteInteriorS;
        } else {
            return 0.0;
        }
    }
}
