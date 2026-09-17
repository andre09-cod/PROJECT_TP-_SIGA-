package siga;

/** Produto concreto de conexão da família MySQL. */
public class ConexaoMySQL implements Conexao {
    @Override
    public void abrir() {
        System.out.println("[MySQL] conexão aberta");
    }
}
