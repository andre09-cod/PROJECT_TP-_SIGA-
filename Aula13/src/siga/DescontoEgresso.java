package siga;

/** Política de desconto de 10% para egressos. */
public class DescontoEgresso implements PoliticaDesconto {
    private static final double PERCENTUAL = 0.10;

    @Override
    public double calcular(Aluno aluno, double valorBase) {
        return aluno.isEgresso() ? valorBase * (1.0 - PERCENTUAL) : valorBase;
    }
}
