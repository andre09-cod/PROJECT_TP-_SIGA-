package siga.ui;

import siga.matricula.FachadaMatricula;

/** Tela fina: depende somente da FachadaMatricula e trata erros de execução. */
public class TelaMatricula {
    private final FachadaMatricula fachada;

    public TelaMatricula(FachadaMatricula fachada) {
        this.fachada = fachada;
    }

    public void abrir() {
        try {
            System.out.println(fachada.executarMatricula());
        } catch (RuntimeException erro) {
            System.err.println("Não foi possível concluir a matrícula: " + erro.getMessage());
        }
    }
}
