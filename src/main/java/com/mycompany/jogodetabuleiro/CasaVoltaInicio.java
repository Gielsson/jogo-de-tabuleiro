package com.mycompany.jogodetabuleiro;

import java.util.List;

public class CasaVoltaInicio extends Casa {

    public CasaVoltaInicio(int numero) {
        super(numero);
    }

 
    public void executarEfeito(Jogo jogo, Jogador jogador) {
        List<Jogador> jogadores = jogo.getJogadores();

        System.out.println(jogador.getCor() + " caiu na casa " + getNumero()
                + " e escolhe quem volta ao início.");
        Jogador escolhido = jogo.getConsole().escolherJogador(jogadores);

        System.out.println(escolhido.getCor() + " volta para o início!");
        escolhido.voltarAoInicio();
    }
}
