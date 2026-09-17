package siga;

/** Produto concreto de comando da família MySQL. */
public class ComandoMySQL implements Comando {
    @Override
    public void executar(String sql) {
        System.out.println("[MySQL] executando: " + sql);
    }
}
