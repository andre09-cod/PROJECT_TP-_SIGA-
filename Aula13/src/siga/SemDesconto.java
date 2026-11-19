package siga;

/** Política padrão, aplicada quando o aluno não possui benefício. */
public class SemDesconto implements PoliticaDesconto {
    @Override
    public double calcular(Aluno aluno, double valorBase) {
        return valorBase;
    }
}
