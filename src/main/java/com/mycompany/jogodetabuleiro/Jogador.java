
package com.mycompany.jogodetabuleiro;
public abstract class Jogador {
    private String cor;
    private int posicao;
    private int jogadas;
    private boolean perdeProximaRodada;

    //executado para que sempre que m jogador novo for criado, configure seu estado inicial 
    public Jogador(String cor) {
        this.cor = cor; //guarda a cor escolhida pelo jogador
        this.posicao = 0;
        this.jogadas = 0; //inicializa cm zero
        this.perdeProximaRodada = false;
    }

    
    public abstract void rolarDados(Dados dados);// Cada tipo de jogador rola os dados do seu jeito
    public abstract String getTipo();

    public String getCor() {
        return cor; 
    }
    public int getPosicao() { 
        return posicao; // le a casa atual
    }
    public void setPosicao(int posicao) { 
        this.posicao = posicao; //atualiza a posição quando jog avança no tab
    }
    public int getJogadas() { 
        return jogadas; //consulta quantas jogadas o jog ja fez
    }
    public void contarJogada() {
        jogadas++; 
    }

    public void perderProximaRodada() { 
        perdeProximaRodada = true;
        //indica que o jogador caiu em uma casa de penalização
    }
    public boolean isPerdeProximaRodada() { 
        return perdeProximaRodada;
        //retorna true ou false para saber se o jog deve passar a vez
    }
    public void cancelarPerdaDeRodada() { 
        perdeProximaRodada = false;
    }

    public void voltarAoInicio() {
        posicao = 0; 
    }
    //recebe outro objeto jogador como parametro e clona tds os seus atributos 
    //para um novo objeto
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
