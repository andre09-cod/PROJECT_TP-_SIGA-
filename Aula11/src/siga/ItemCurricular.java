package siga;

/**
 * Componente do Composite: tipo comum a Disciplina (folha) e Modulo
 * (composto). O cliente trata os dois de modo uniforme, sem instanceof.
 */
public interface ItemCurricular {

    String getNome();

    int getCargaHoraria();

    void imprimir(int nivel);
}
