package com.mycompany.jogodetabuleiro;

public class MovimentoPorDados implements FonteDeMovimento {

    private final Dados dados = new Dados();

    
    public int obterDestino(Jogador jogador) {
        jogador.rolarDados(dados);
        System.out.println("  Dado: " + dados.getDado1() + " e " + dados.getDado2()
                + " (soma " + dados.getSoma() + ")");
        jogador.contarJogada();
        return jogador.getPosicao() + dados.getSoma();
    }

    public boolean saiuDadosIguais() {
        return dados.saoIguais();
    }
}
