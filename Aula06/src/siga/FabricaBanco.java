package siga;

/**
 * Abstract Factory: define a família de produtos de acesso a dados.
 */
public interface FabricaBanco {
    Conexao criarConexao();
    Comando criarComando();
}
