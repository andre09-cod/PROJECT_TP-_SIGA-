package siga;
/**
 * Sistema de Gestão Acadêmica Simplificado (SIGA)
 * Técnicas de Programação II - Fatec de Porto Ferreira
 *
 * ATENÇÃO: código INICIAL da disciplina.
 * Esta classe apresenta, propositalmente, problemas de orientação a objetos
 * que serão corrigidos na atividade prática da Aula 1.
 *
 * Problema principal: os atributos são PÚBLICOS, expondo o estado interno
 * do objeto e permitindo que qualquer código o coloque em um estado inválido
 * (por exemplo, uma média negativa ou maior que 10).
 */

public class Aluno extends Pessoa {

    private String matricula;
    private double media;
    private boolean ativo;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (matricula != null && !matricula.trim().isEmpty()) {
            this.matricula = matricula;
        } else {
            System.out.println("A matrícula não pode ser vazia.");
        }
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        if (media >= 0 && media <= 10) {
            this.media = media;
        } else {
            System.out.println("A média deve estar entre 0 e 10.");
        }
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
    // Sem construtor: o objeto pode ser criado em estado incompleto/inconsistente.

