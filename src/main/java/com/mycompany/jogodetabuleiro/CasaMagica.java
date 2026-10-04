package com.mycompany.jogodetabuleiro;
import java.util.Comparator;

public class CasaMagica extends Casa {

    public CasaMagica(int numero) {
        super(numero);
    }

    
    public void executarEfeito(Jogo jogo, Jogador jogador) {
        Jogador ultimo = jogo.getJogadores().stream()
                .min(Comparator.comparingInt(Jogador::getPosicao))
                .get();

        if (ultimo == jogador || ultimo.getPosicao() == jogador.getPosicao()) {
            System.out.println(jogador.getCor() + " já é o último colocado. Não sai do lugar.");
            return;
        }

        System.out.println(jogador.getCor() + " troca de lugar com " + ultimo.getCor() + "!");
        int posicaoAntiga = jogador.getPosicao();
        jogador.setPosicao(ultimo.getPosicao());
        ultimo.setPosicao(posicaoAntiga);
    }
}