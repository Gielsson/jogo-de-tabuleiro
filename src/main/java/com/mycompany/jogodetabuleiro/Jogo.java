package com.mycompany.jogodetabuleiro;

import java.util.List;

// controla a partida de quem eh a vez, as regras dos dados e quem venceu
public class Jogo {
    public static final int CASA_FINAL = 40; // chegou na 40 (ou passou), ganhou

    private List<Jogador> jogadores;
    private Tabuleiro tabuleiro;
    private FonteDeMovimento fonteDeMovimento = new MovimentoPorDados();
    private Jogador vencedor; // fica null ate alguem ganhar

    public Jogo(List<Jogador> jogadores) {
        this.jogadores = jogadores;
        this.tabuleiro = new Tabuleiro();
        this.vencedor = null;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    // Troca um jogador por outro na lista, usado quando o tipo do jogador muda na casa surpresa
    public void substituirJogador(Jogador antigo, Jogador novo) {
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i) == antigo) {
                jogadores.set(i, novo);
            }
        }
    }

    // Troca a forma como o jogador se move: dados normais ou Modo Debug (digitar a casa de destino)
    public void ativarModoDebug() {
        fonteDeMovimento = new MovimentoDebug();
    }

    // Repete rodadas ate aparecer um vencedor
    public void iniciar() {
        int rodada = 1;
        while (vencedor == null) {
            System.out.println("=== Rodada " + rodada + " ===");
            // Cada rodada, todos jogam na ordem da lista
            for (int i = 0; i < jogadores.size(); i++) {
                jogarVez(i);
                if (vencedor != null) {
                    break; // alguem ganhou, nao precisa os outros jogarem
                }
            }
            rodada++;
        }
        mostrarRelatorio();
    }

    // Vez de um jogador. Recebe o indice, e nao o jogador, porque a casa surpresa pode trocar o objeto da lista,
    //entao sempre buscamos o jogador atual pelo indice
    private void jogarVez(int indice) {
        Jogador jogador = jogadores.get(indice);
        System.out.println("Vez do jogador " + jogador.getCor());

        // Se caiu numa casa de perder rodada, so pula a vez e a perda acaba
        if (jogador.isPerdeProximaRodada()) {
            System.out.println("  " + jogador.getCor() + " perdeu a rodada.");
            jogador.cancelarPerdaDeRodada();
            return;
        }

        boolean jogaDeNovo;
        do {
            jogaDeNovo = false;
            jogador = jogadores.get(indice); // pega de novo, caso tenha mudado de tipo

            Entrada.esperarEnter("  Pressione Enter para jogar os dados...");

            // A fonte de movimento decide o destino (dados normais ou casa digitada no Modo Debug)
            int destino = fonteDeMovimento.obterDestino(jogador);
            jogador.setPosicao(destino);
            System.out.println("  -> casa " + jogador.getPosicao());

            // Chegou ao fim com os dados vitoria
            if (jogador.getPosicao() >= CASA_FINAL) {
                vencedor = jogador;
                return;
            }

            // Executa o efeito da casa onde caiu,cada casa faz o seu
            tabuleiro.getCasa(jogador.getPosicao()).executarEfeito(this, jogador);

            // O efeito da casa, ex: sorte, +3, pode ter levado o jogador ate o fim
            jogador = jogadores.get(indice);
            if (jogador.getPosicao() >= CASA_FINAL) {
                vencedor = jogador;
                return;
            }

            // Dados iguais joga de novo, a nao ser que tenha caido em casa de perder rodada
            // (no Modo Debug nunca sai dados iguais, entao essa regra nao se aplica)
            if (fonteDeMovimento.saiuDadosIguais() && !jogador.isPerdeProximaRodada()) {
                System.out.println("  Dados iguais! " + jogador.getCor() + " joga de novo.");
                jogaDeNovo = true;
            }
        } while (jogaDeNovo);
    }

    // Mostra o vencedor e a situacao de cada jogador no fim
    private void mostrarRelatorio() {
        System.out.println();
        System.out.println("===== FIM DE JOGO =====");
        System.out.println("Vencedor: " + vencedor.getCor()
                + " (" + vencedor.getJogadas() + " jogadas)");
        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getCor() + " [" + jogador.getTipo() + "]"
                    + " - posicao: " + jogador.getPosicao()
                    + " - jogadas: " + jogador.getJogadas());
        }
    }
}