package com.mycompany.jogodetabuleiro;

public class JogadorNormal extends Jogador {

    public JogadorNormal(String cor) {
        super(cor);
    }

    // Usado na casa surpresa: vira Normal mantendo cor, posicao e jogadas
    public JogadorNormal(Jogador outro) {
        super(outro);
    }

    public void rolarDados(Dados dados) {
        dados.rolar();
    }

    public String getTipo() {
        return "Normal";
    }
}