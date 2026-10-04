package com.mycompany.jogodetabuleiro;

public interface FonteDeMovimento {
    int obterDestino(Jogador jogador);
    boolean saiuDadosIguais();
}