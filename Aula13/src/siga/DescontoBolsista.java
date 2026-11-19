package siga;

/** Política de desconto de 50% para alunos bolsistas. */
public class DescontoBolsista implements PoliticaDesconto {
    private static final double PERCENTUAL = 0.50;

    @Override
    public double calcular(Aluno aluno, double valorBase) {
        return aluno.isBolsista() ? valorBase * (1.0 - PERCENTUAL) : valorBase;
    }
}
