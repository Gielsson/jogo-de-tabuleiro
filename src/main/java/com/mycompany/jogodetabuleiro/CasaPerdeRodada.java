package com.mycompany.jogodetabuleiro;

public class CasaPerdeRodada extends Casa{


	    public CasaPerdeRodada(int numero) {
	        super(numero);
	    }

	    public void executarEfeito(Jogo jogo, Jogador jogador) {
	        System.out.println(jogador.getCor() + " caiu na casa " + getNumero()
	                + " e perde a próxima rodada!");
	        jogador.perderProximaRodada();
	    }
	}

