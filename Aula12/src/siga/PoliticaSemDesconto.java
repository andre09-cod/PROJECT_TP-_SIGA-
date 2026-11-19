package siga;

/** Aluno sem direito a desconto. Percentual escrito uma única vez, aqui. */
public class PoliticaSemDesconto implements PoliticaDesconto {

    private static final double FATOR = 1.00;

    @Override
    public double aplicar(double valorBase) {
        return valorBase * FATOR;
    }
}
