package com.mycompany.jogodetabuleiro;
import java.util.List;
 
public class Jogo {
    private List<Jogador> jogadores;
    private Tabuleiro tabuleiro;
    private Dados dados;
    private Jogador vencedor;
 
    public Jogo(List<Jogador> jogadores) {
        this.jogadores = jogadores;
        this.tabuleiro = new Tabuleiro();
        this.dados = new Dados();
    }
 
    public List<Jogador> getJogadores() {
        return jogadores;
    }
 
    public void substituirJogador(Jogador antigo, Jogador novo) {
        int indice = jogadores.indexOf(antigo);
        jogadores.set(indice, novo);
    }
   
}