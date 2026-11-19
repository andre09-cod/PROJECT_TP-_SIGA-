package siga;

/** O desconto é delegado à política injetada: nenhum if de desconto aqui. */
public class Matricula {

    private final Aluno aluno;
    private final String codigoTurma;
    private final PoliticaDesconto politica;

    public Matricula(Aluno aluno, String codigoTurma, PoliticaDesconto politica) {
        this.aluno = aluno;
        this.codigoTurma = codigoTurma;
        this.politica = politica;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public PoliticaDesconto getPolitica() {
        return politica;
    }

    public double calcularValor(double valorBase) {
        return politica.aplicar(valorBase);
    }

    @Override
    public String toString() {
        return aluno.getNome() + " em " + codigoTurma;
    }
}
