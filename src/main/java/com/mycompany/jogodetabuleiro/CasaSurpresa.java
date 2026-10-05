package com.mycompany.jogodetabuleiro;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class CasaSurpresa extends Casa {

    private static final Random SORTEIO = new Random();
    //random sorteio cria um gerador de numeros aleatorios para sortear uma carta aleatoria
    //function serve para receber uum jogador de um tipo e retornar de outro tipo
    private static final List<Function<Jogador, Jogador>> CARTAS = List.of(
            JogadorNormal::new, //usa o :: para apontar diretamente para o molde que cria o objeto
            JogadorSortudo::new,
            JogadorAzarado::new
    ); //list.of cria uma lista de constantes contendo 3 opções

    public CasaSurpresa(int numero) {
        super(numero);
    }

    
    public void executarEfeito(Jogo jogo, Jogador jogador) {
        //carta.get vai bscar a carta sorteada na lista
        Function<Jogador, Jogador> carta = CARTAS.get(SORTEIO.nextInt(CARTAS.size()));
        Jogador novoJogador = carta.apply(jogador);
//carta.apply(jogador)aplica a transformaçã ao jogador atual, criando um novo jog de comport dif
        System.out.println(jogador.getCor() + " caiu na casa surpresa (13) e virou "
                + novoJogador.getClass().getSimpleName() + "!");

        jogo.substituirJogador(jogador, novoJogador);
        //troca o jog antigo pelo novo
    }
}
