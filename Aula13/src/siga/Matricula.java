package siga;

/** Matrícula que recebe a política de desconto por injeção de dependência. */
public class Matricula {
    private final Aluno aluno;
    private final String codigoTurma;
    private final PoliticaDesconto politicaDesconto;

    public Matricula(Aluno aluno, String codigoTurma, PoliticaDesconto politicaDesconto) {
        this.aluno = aluno;
        this.codigoTurma = codigoTurma;
        this.politicaDesconto = politicaDesconto;
    }

    public Aluno getAluno() { return aluno; }
    public String getCodigoTurma() { return codigoTurma; }

    public double calcularValor(double valorBase) {
        return politicaDesconto.calcular(aluno, valorBase);
    }

    @Override
    public String toString() {
        return aluno.getNome() + " em " + codigoTurma;
    }
}
