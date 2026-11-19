package siga;

/** Fato já consumado, entregue a cada ouvinte. */
public record EventoMatricula(Matricula matricula, boolean turmaLotada) { }
