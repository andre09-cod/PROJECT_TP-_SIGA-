package siga;

/** Bolsista paga 50% do valor base. Percentual escrito uma única vez, aqui. */
public class PoliticaBolsista implements PoliticaDesconto {

    private static final double FATOR = 0.50;

    @Override
    public double aplicar(double valorBase) {
        return valorBase * FATOR;
    }
}
