package com.mycompany.jogodetabuleiro;

import java.util.List;

public class Jogodetabuleiro {
    public static void main(String[] args) {
        List<Jogador> jogadores = Menu.criarJogadores();

        Jogo jogo = new Jogo(jogadores);
    int modo = Entrada.lerInt("Modo de jogo(1 - Normal, 2-Debug): ",1, 2);
            if (modo == 2) {
                jogo.ativarModoDebug();
            
        }
        jogo.iniciar();   
    }
}
