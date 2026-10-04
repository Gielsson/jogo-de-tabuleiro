package com.mycompany.jogodetabuleiro;

public class MovimentoDebug implements FonteDeMovimento {

    @Override
    public int obterDestino(Jogador jogador) {
        jogador.contarJogada();
        return Entrada.lerInt("Modo Debug - digite a casa de destino (0 a 40): ", 0, Jogo.CASA_FINAL);
    }

    public boolean saiuDadosIguais() {
        return false; // no modo Debug não existe a regra de dados iguais
    }
}