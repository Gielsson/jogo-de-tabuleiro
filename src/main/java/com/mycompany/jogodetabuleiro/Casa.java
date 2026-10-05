package com.mycompany.jogodetabuleiro;

public abstract class Casa { //abstract pq ela serve como molde base. 
		//final garante seja constante
	    private final int numero; // atributo para guardar o num. da casa no tab
	    //private faz cm q as outras classes  leiam esse valor através do método getNumero()
	    public Casa(int numero) {
	        this.numero = numero;
	    }

	    public int getNumero() {
	        return numero;
	    }

	  
	public abstract void executarEfeito(Jogo jogo, Jogador jogador);
	//sem estrutura pq cada tipo de casa tem uma estrutura diferente.
	//obriga tds as classes filhas a criarem a sua propria versao de como o efeto acontece
}
