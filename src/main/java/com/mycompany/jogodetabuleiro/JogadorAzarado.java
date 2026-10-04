package com.mycompany.jogodetabuleiro;

// jog azarado: a soma dos dados eh sempre 6 ou menos
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

    // Azarado nao aproveita a casa da sorte (a CasaSorte consulta isso)
    public boolean recebeBonusDaSorte() {
        return false;
    }
}
