package siga;

/** Contrato comum para todas as reações ao evento de matrícula. */
public interface ObservadorMatricula {
    void atualizar(EventoMatricula evento);
}
