package siga;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject: guarda os ouvintes e os notifica.
 *  - percorre uma CÓPIA da lista, então um ouvinte pode (des)registrar
 *    outro durante a notificação sem quebrar a iteração;
 *  - protege CADA chamada: a falha de um ouvinte é registrada e os
 *    seguintes continuam sendo notificados.
 */
public class PublicadorMatricula {

    private final List<OuvinteMatricula> ouvintes = new ArrayList<>();

    public void adicionar(OuvinteMatricula ouvinte) {
        ouvintes.add(ouvinte);
    }

    public void remover(OuvinteMatricula ouvinte) {
        ouvintes.remove(ouvinte);
    }

    public void publicar(EventoMatricula evento) {
        for (OuvinteMatricula ouvinte : new ArrayList<>(ouvintes)) {
            try {
                ouvinte.aoMatricular(evento);
            } catch (RuntimeException e) {
                System.out.println("   [erro] " + ouvinte.getClass().getSimpleName()
                        + ": " + e.getMessage());
            }
        }
    }
}
