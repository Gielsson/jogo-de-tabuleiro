
package com.mycompany.jogodetabuleiro;
public abstract class Jogador {
    private String cor;
    private int posicao;
    private int jogadas;
    private boolean perdeProximaRodada;

    public Jogador(String cor) {
        this.cor = cor;
        this.posicao = 0;
        this.jogadas = 0;
        this.perdeProximaRodada = false;
    }

    
    public abstract void rolarDados(Dados dados);// Cada tipo de jogador rola os dados do seu jeito
    public abstract String getTipo();

    public String getCor() {
        return cor; 
    }
    public int getPosicao() { 
        return posicao; 
    }
    public void setPosicao(int posicao) { 
        this.posicao = posicao; 
    }
    public int getJogadas() { 
        return jogadas;
    }
    public void contarJogada() {
        jogadas++; 
    }

    public void perderProximaRodada() { 
        perdeProximaRodada = true; 
    }
    public boolean isPerdeProximaRodada() { 
        return perdeProximaRodada;
    }
    public void cancelarPerdaDeRodada() { 
        perdeProximaRodada = false;
    }

    public void voltarAoInicio() {
        posicao = 0; 
    }
    protected Jogador(Jogador outro) {
    this.cor = outro.cor;
    this.posicao = outro.posicao;
    this.jogadas = outro.jogadas;
    this.perdeProximaRodada = outro.perdeProximaRodada;
}

public boolean recebeBonusDaSorte() {
    return true;
}
}
