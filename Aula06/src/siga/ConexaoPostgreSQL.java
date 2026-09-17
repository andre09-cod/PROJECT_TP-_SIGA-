package siga;

/** Produto concreto de conexão da família PostgreSQL. */
public class ConexaoPostgreSQL implements Conexao {
    @Override
    public void abrir() {
        System.out.println("[PostgreSQL] conexão aberta");
    }
}
