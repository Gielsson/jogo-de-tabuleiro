package com.mycompany.jogodetabuleiro;

import java.util.ArrayList;
import java.util.List;

public class Jogodetabuleiro {
    public static void main(String[] args) {
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new JogadorNormal());
        jogadores.add(new JogadorAzarado());

        Jogo jogo = new Jogo(jogadores);
        jogo.iniciar();
    }
}