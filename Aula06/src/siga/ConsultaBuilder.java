package siga;

/**
 * Builder para montar consultas de forma legível e com parâmetros opcionais
 * nomeados, evitando chamadas com muitos argumentos posicionais.
 */
public class ConsultaBuilder {
    private final String tabela;
    private String filtro;
    private String ordenacao;
    private int limite;
    private int offset;
    private int timeoutSegundos;
    private boolean somenteAtivos;

    private ConsultaBuilder(String tabela) {
        if (tabela == null || tabela.isBlank()) {
            throw new IllegalArgumentException("A tabela deve ser informada.");
        }
        this.tabela = tabela;
    }

    public static ConsultaBuilder paraTabela(String tabela) {
        return new ConsultaBuilder(tabela);
    }

    public ConsultaBuilder comFiltro(String filtro) {
        this.filtro = filtro;
        return this;
    }

    public ConsultaBuilder comOrdenacao(String ordenacao) {
        this.ordenacao = ordenacao;
        return this;
    }

    public ConsultaBuilder comLimite(int limite) {
        if (limite < 0) {
            throw new IllegalArgumentException("O limite não pode ser negativo.");
        }
        this.limite = limite;
        return this;
    }

    public ConsultaBuilder comOffset(int offset) {
        if (offset < 0) {
            throw new IllegalArgumentException("O offset não pode ser negativo.");
        }
        this.offset = offset;
        return this;
    }

    public ConsultaBuilder comTimeout(int timeoutSegundos) {
        if (timeoutSegundos < 0) {
            throw new IllegalArgumentException("O timeout não pode ser negativo.");
        }
        this.timeoutSegundos = timeoutSegundos;
        return this;
    }

    public ConsultaBuilder somenteAtivos() {
        this.somenteAtivos = true;
        return this;
    }

    public String construir() {
        StringBuilder sb = new StringBuilder("SELECT * FROM ").append(tabela);

        if (filtro != null && !filtro.isBlank()) {
            sb.append(" WHERE ").append(filtro);
        }

        if (somenteAtivos) {
            sb.append(filtro != null && !filtro.isBlank() ? " AND " : " WHERE ")
              .append("ativo = 1");
        }

        if (ordenacao != null && !ordenacao.isBlank()) {
            sb.append(" ORDER BY ").append(ordenacao);
        }
        if (limite > 0) {
            sb.append(" LIMIT ").append(limite);
        }
        if (offset > 0) {
            sb.append(" OFFSET ").append(offset);
        }

        return sb.toString();
    }

    /** Timeout configurado pelo Builder, disponível para a camada de execução. */
    public int getTimeoutSegundos() {
        return timeoutSegundos;
    }
}
