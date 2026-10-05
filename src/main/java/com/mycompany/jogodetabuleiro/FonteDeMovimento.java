package com.mycompany.jogodetabuleiro;

public interface FonteDeMovimento {
    int obterDestino(Jogador jogador);
    //Calcula e devolve o valor ou a nova posição para onde o jogador se vai deslocar
    boolean saiuDadosIguais();
    //verifica se o lançamento associado resultou em valores iguais
}
