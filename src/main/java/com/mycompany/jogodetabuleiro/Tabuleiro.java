package com.mycompany.jogodetabuleiro;

public class Tabuleiro {

    public static final int TAMANHO = 40;

    private final Casa[] casas = new Casa[TAMANHO + 1];

    public Tabuleiro() {
        // Preenche tudo com casas simples primeiro
        for (int i = 0; i <= TAMANHO; i++) {
            casas[i] = new CasaSimples(i);
        }

        //sobrescreve só as posições especiais
        casas[13] = new CasaSurpresa(13);

        for (int n : new int[]{10, 25, 38}) {
            casas[n] = new CasaPerdeRodada(n);
        }
        for (int n : new int[]{5, 15, 30}) {
            casas[n] = new CasaSorte(n);
        }
        for (int n : new int[]{17, 27}) {
            casas[n] = new CasaVoltaInicio(n);
        }
        for (int n : new int[]{20, 35}) {
            casas[n] = new CasaMagica(n);
        }
    }
// Evita a sobrecarga da array. Usada por Jogo
    public Casa getCasa(int posicao) {
        int indice = Math.max(0, Math.min(posicao, TAMANHO));
        return casas[indice];
    }
}