package com.mycompany.jogodetabuleiro;

import java.util.List;

public class Jogodetabuleiro {
    public static void main(String[] args) {
        List<Jogador> jogadores = Menu.criarJogadores();

        Jogo jogo = new Jogo(jogadores);
        jogo.iniciar();
    }
}