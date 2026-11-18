package siga;

/** Servidor paga 80% do valor base. Percentual escrito uma única vez, aqui. */
public class PoliticaServidor implements PoliticaDesconto {

    private static final double FATOR = 0.80;

    @Override
    public double aplicar(double valorBase) {
        return valorBase * FATOR;
    }
}
