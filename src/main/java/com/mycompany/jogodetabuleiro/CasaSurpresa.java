package com.mycompany.jogodetabuleiro;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class CasaSurpresa extends Casa {

    private static final Random SORTEIO = new Random();

    private static final List<Function<Jogador, Jogador>> CARTAS = List.of(
            JogadorNormal::new,
            JogadorSortudo::new,
            JogadorAzarado::new
    );

    public CasaSurpresa(int numero) {
        super(numero);
    }

    
    public void executarEfeito(Jogo jogo, Jogador jogador) {
        Function<Jogador, Jogador> carta = CARTAS.get(SORTEIO.nextInt(CARTAS.size()));
        Jogador novoJogador = carta.apply(jogador);

        System.out.println(jogador.getCor() + " caiu na casa surpresa (13) e virou "
                + novoJogador.getClass().getSimpleName() + "!");

        jogo.substituirJogador(jogador, novoJogador);
    }
}