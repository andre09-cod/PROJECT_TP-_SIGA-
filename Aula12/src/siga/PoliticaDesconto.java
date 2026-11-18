package siga;

/** Strategy: uma política de desconto sobre o valor base da mensalidade. */
public interface PoliticaDesconto {

    double aplicar(double valorBase);
}
