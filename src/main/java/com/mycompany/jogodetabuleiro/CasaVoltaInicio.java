package com.mycompany.jogodetabuleiro;

import java.util.ArrayList;
import java.util.List;

// Casas 17 e 27  quem cai escolhe outro jogador para voltar ao inicio
public class CasaVoltaInicio extends Casa {

    public CasaVoltaInicio(int numero) {
        super(numero);
    }

    public void executarEfeito(Jogo jogo, Jogador jogador) {
        System.out.println(jogador.getCor() + " caiu na casa " + getNumero()
                + " e escolhe um jogador para voltar ao inicio!");

        // monta a lista de opcoes: todos menos quem caiu na casa
        List<Jogador> opcoes = new ArrayList<>();
        for (Jogador outro : jogo.getJogadores()) {
            if (outro != jogador) {
                opcoes.add(outro);
            }
        }

        // Mostra as opcoes numeradas
        for (int i = 0; i < opcoes.size(); i++) {
            Jogador o = opcoes.get(i);
            System.out.println("  " + (i + 1) + " - " + o.getCor() + " (casa " + o.getPosicao() + ")");
        }

        // Le a escolha e manda o escolhido de volta para a casa 0
        int escolha = Entrada.lerInt("Quem volta ao inicio? ", 1, opcoes.size());
        Jogador escolhido = opcoes.get(escolha - 1);
        escolhido.voltarAoInicio();
        System.out.println("  " + escolhido.getCor() + " voltou para o inicio.");
    }
}
