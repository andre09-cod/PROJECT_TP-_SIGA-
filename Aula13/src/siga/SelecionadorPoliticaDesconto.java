package siga;

/** Escolhe a política respeitando a prioridade das regras originais. */
public class SelecionadorPoliticaDesconto {
    public PoliticaDesconto selecionar(Aluno aluno) {
        if (aluno.isBolsista()) {
            return new DescontoBolsista();
        } else if (aluno.isServidor()) {
            return new DescontoServidor();
        } else if (aluno.isEgresso()) {
            return new DescontoEgresso();
        }
        return new SemDesconto();
    }
}
