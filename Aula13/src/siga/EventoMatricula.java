package siga;

/** Evento publicado depois que uma matrícula é registrada. */
public class EventoMatricula {
    private final Matricula matricula;
    private final boolean turmaLotada;

    public EventoMatricula(Matricula matricula, boolean turmaLotada) {
        this.matricula = matricula;
        this.turmaLotada = turmaLotada;
    }
    public Matricula getMatricula() { return matricula; }
    public boolean isTurmaLotada() { return turmaLotada; }
}
