package siga;

/** Egresso paga 90% do valor base. Percentual escrito uma única vez, aqui. */
public class PoliticaEgresso implements PoliticaDesconto {

    private static final double FATOR = 0.90;

    @Override
    public double aplicar(double valorBase) {
        return valorBase * FATOR;
    }
}
