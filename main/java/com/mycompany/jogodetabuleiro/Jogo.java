package com.mycompany.jogodetabuleiro;

import java.util.List;

public class Jogo {
    public static final int CASA_FINAL = 40;

    private List<Jogador> jogadores;
    private Tabuleiro tabuleiro;
    private Dados dados;
    private Jogador vencedor;

    public Jogo(List<Jogador> jogadores) {
        this.jogadores = jogadores;
        this.tabuleiro = new Tabuleiro();
        this.dados = new Dados();
        this.vencedor = null;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    // Usado na casa surpresa para trocar o tipo do jogador
    public void substituirJogador(Jogador antigo, Jogador novo) {
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i) == antigo) {
                jogadores.set(i, novo);
            }
        }
    }

    public void iniciar() {
        int rodada = 1;
        while (vencedor == null) {
            System.out.println("=== Rodada " + rodada + " ===");
            for (int i = 0; i < jogadores.size(); i++) {
                jogarVez(i);
                if (vencedor != null) {
                    break;
                }
            }
            rodada++;
        }
        mostrarRelatorio();
    }

    // Recebe o indice (e nao o jogador) porque a casa surpresa pode trocar o objeto da lista
    private void jogarVez(int indice) {
        Jogador jogador = jogadores.get(indice);
        System.out.println("Vez do jogador " + jogador.getCor());

        // Quem caiu numa casa de perder rodada so pula a vez
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

            jogador.rolarDados(dados);
            jogador.contarJogada();
            jogador.setPosicao(jogador.getPosicao() + dados.getSoma());
            System.out.println("  Dado: " + dados.getDado1() + " e " + dados.getDado2()
                    + " (soma " + dados.getSoma() + ") -> casa " + jogador.getPosicao());

            if (jogador.getPosicao() >= CASA_FINAL) {
                vencedor = jogador;
                return;
            }

            tabuleiro.getCasa(jogador.getPosicao()).executarEfeito(this, jogador);

            // O efeito da casa (ex: sorte, +3) pode ter levado o jogador ate o fim
            jogador = jogadores.get(indice);
            if (jogador.getPosicao() >= CASA_FINAL) {
                vencedor = jogador;
                return;
            }

            // Dados iguais: joga de novo (a nao ser que tenha caido em casa de perder rodada)
            if (dados.saoIguais() && !jogador.isPerdeProximaRodada()) {
                System.out.println("  Dados iguais! " + jogador.getCor() + " joga de novo.");
                jogaDeNovo = true;
            }
        } while (jogaDeNovo);
    }

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