package siga;

import java.util.ArrayList;
import java.util.List;

/**
 * Composto da estrutura curricular. A coleção agora é de ItemCurricular,
 * então o compilador volta a ajudar e a recursão fica dentro do próprio
 * Modulo: cada filho sabe calcular e imprimir a si mesmo.
 */
public class Modulo implements ItemCurricular {

    private final String nome;
    private final List<ItemCurricular> filhos = new ArrayList<>();

    public Modulo(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void adicionar(ItemCurricular filho) {
        filhos.add(filho);
    }

    public List<ItemCurricular> getFilhos() {
        return filhos;
    }

    @Override
    public int getCargaHoraria() {
        int total = 0;
        for (ItemCurricular filho : filhos) {
            total += filho.getCargaHoraria();
        }
        return total;
    }

    @Override
    public void imprimir(int nivel) {
        System.out.println("  ".repeat(nivel) + "[" + nome + "]");
        for (ItemCurricular filho : filhos) {
            filho.imprimir(nivel + 1);
        }
    }
}
