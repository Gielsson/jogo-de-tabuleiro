package com.mycompany.jogodetabuleiro;

import java.util.List;

public class CasaVoltaInicio extends Casa {

    public CasaVoltaInicio(int numero) {
        super(numero);
    }

    @Override
    public void executarEfeito(Jogo jogo, Jogador jogador) {
        List<Jogador> jogadores = jogo.getJogadores();

        System.out.println(jogador.getCor() + " caiu na casa " + getNumero()
                + " e escolhe quem volta ao início.");
        for (int i = 0; i < jogadores.size(); i++) {
            Jogador j = jogadores.get(i);
            System.out.println("  [" + i + "] " + j.getCor() + " (casa " + j.getPosicao() + ")");
        }

        int escolha = Entrada.lerInt("Digite o número: ", 0, jogadores.size() - 1);
        Jogador escolhido = jogadores.get(escolha);

        System.out.println(escolhido.getCor() + " volta para o início!");
        escolhido.voltarAoInicio();
    }
}