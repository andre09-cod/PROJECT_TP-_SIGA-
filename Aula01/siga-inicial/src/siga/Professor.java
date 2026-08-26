package siga;

/**
 * Código INICIAL da disciplina.
 *
 * Observe que Aluno e Professor repetem os atributos "nome" e "matricula"/"registro".
 * Na atividade da Aula 1, essa duplicação será eliminada com a criação de uma
 * superclasse comum (Pessoa), aplicando herança.
 */

public class Professor extends Pessoa {

    private String disciplina;

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        if (disciplina != null && !disciplina.trim().isEmpty()) {
            this.disciplina = disciplina;
        } else {
            System.out.println("A disciplina não pode ser vazia.");
        }
    }
}