package com.mycompany.jogodetabuleiro;

public abstract class Casa {
	
	    private final int numero;
	    
	    public Casa(int numero) {
	        this.numero = numero;
	    }

	    public int getNumero() {
	        return numero;
	    }

	  
	public abstract void executarEfeito(Jogo jogo, Jogador jogador);
	
}
