package siga;

/** Observer: qualquer reação a uma matrícula já realizada. */
public interface OuvinteMatricula {

    void aoMatricular(EventoMatricula evento);
}
