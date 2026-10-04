package com.mycompany.jogodetabuleiro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//o menu monta a lista de jogadores da partida
public class Menu {
    private static final String[] CORES = {"Vermelho", "Azul", "Verde", "Amarelo", "Preto", "Branco"};

    public static List<Jogador> criarJogadores() {
        System.out.println("===== JOGO DE TABULEIRO =====");
        int quantidade = Entrada.lerInt("Quantos jogadores (2 a 6)? ", 2, 6);

        // repete ate a escolha ser valida,pelo menos 2 tipos diferentes
        while (true) {
            List<Jogador> jogadores = new ArrayList<>();
            List<String> coresLivres = new ArrayList<>(Arrays.asList(CORES));

            for (int i = 1; i <= quantidade; i++) {
                // Escolha da cor, a cor escolhida sai da lista, nao repete
                System.out.println();
                System.out.println("Jogador " + i + " - escolha a cor:");
                for (int c = 0; c < coresLivres.size(); c++) {
                    System.out.println("  " + (c + 1) + " - " + coresLivres.get(c));
                }
                int escolhaCor = Entrada.lerInt("Cor: ", 1, coresLivres.size());
                String cor = coresLivres.remove(escolhaCor - 1);

                // Escolha do tipo
                System.out.println("Tipo do jogador " + cor + ":");
                System.out.println("  1 - Normal");
                System.out.println("  2 - Sortudo");
                System.out.println("  3 - Azarado");
                int tipo = Entrada.lerInt("Tipo: ", 1, 3);

                if (tipo == 1) {
                    jogadores.add(new JogadorNormal(cor));
                } else if (tipo == 2) {
                    jogadores.add(new JogadorSortudo(cor));
                } else {
                    jogadores.add(new JogadorAzarado(cor));
                }
            }

            if (temTiposDiferentes(jogadores)) {
                System.out.println();
                return jogadores;
            }
            System.out.println();
            System.out.println("Precisa ter pelo menos 2 tipos de jogador diferentes. Escolha de novo.");
        }
    }

    // Confere se existe pelo menos um jogador de tipo diferente do primeiro
    private static boolean temTiposDiferentes(List<Jogador> jogadores) {
        String primeiro = jogadores.get(0).getTipo();
        for (Jogador jogador : jogadores) {
            if (!jogador.getTipo().equals(primeiro)) {
                return true;
            }
        }
        return false;
    }
}
