package com.mycompany.jogodetabuleiro;

// Jogador sortudo: a soma dos dados e sempre 7 ou mais
public class JogadorSortudo extends Jogador {

    public JogadorSortudo(String cor) {
        super(cor);
    }

    public JogadorSortudo(Jogador outro) {
        super(outro);
    }

    // Rola de novo ate a soma ser >= 7
    public void rolarDados(Dados dados) {
        do {
            dados.rolar();
        } while (dados.getSoma() < 7);
    }

    public String getTipo() {
        return "Sortudo";
    }
}