package com.mycompany.jogodetabuleiro;

// Casas 20 e 35- o jogador troca de lugar com quem esta em ultimo
public class CasaMagica extends Casa { // diz que a casaMagica herda tudo que a classe Casa tem

    public CasaMagica(int numero) {
        super(numero);
    }

    public void executarEfeito(Jogo jogo, Jogador jogador) {
        // procura o jogador que esta mais atras no tabuleiro
        Jogador ultimo = jogo.getJogadores().get(0); // assume que o ultimo jogador eh o primeiro, para inicializar
        for (Jogador outro : jogo.getJogadores()) { // para cada outrojogador em jogo.getJogadores(), faça...
            if (outro.getPosicao() < ultimo.getPosicao()) { //verifica se o outro esta mais atras na posição
                ultimo = outro;
            }
        }

        // Se ele ja eh o ultimo ou empatado com o ultimo, nao sai do lugar
        if (jogador.getPosicao() <= ultimo.getPosicao()) {
            System.out.println(jogador.getCor() + " caiu na casa magica, mas ja eh o ultimo."
                    + " Fica onde esta.");
            return;
        }

        // Troca as posicoes dos dois
        System.out.println(jogador.getCor() + " caiu na casa magica e troca de lugar com "
                + ultimo.getCor() + "!");
        int posicaoAntiga = jogador.getPosicao();
        jogador.setPosicao(ultimo.getPosicao()); //posicao eh um atributo da classe jogador
        ultimo.setPosicao(posicaoAntiga);
    }
}
