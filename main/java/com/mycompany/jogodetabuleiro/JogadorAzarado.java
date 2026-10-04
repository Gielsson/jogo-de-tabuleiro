package com.mycompany.jogodetabuleiro;

public class JogadorAzarado extends Jogador {

    public JogadorAzarado(String cor) {
        super(cor);
    }

    public JogadorAzarado(Jogador outro) {
        super(outro);
    }

    // Rola de novo ate a soma ser <= 6
    public void rolarDados(Dados dados) {
        do {
            dados.rolar();
        } while (dados.getSoma() > 6);
    }

    public String getTipo() {
        return "Azarado";
    }

    // o jog azarado nao aproveita a casa da sorte
    public boolean recebeBonusDaSorte() {
        return false;
    }
}