package com.mycompany.jogodetabuleiro;

public class Tabuleiro {
    private Casa[] casas = new Casa[41]; // usa o indice como numero da casa (1 a 40)

    public Tabuleiro() {
        //primeiro sao tds simples
        for (int i = 0; i < casas.length; i++) {
            casas[i] = new CasaSimples(i);
        }

        //casas de perder rodada
        casas[10] = new CasaPerdeRodada(10);
        casas[25] = new CasaPerdeRodada(25);
        casas[38] = new CasaPerdeRodada(38);

        //casas da sorte
        casas[5] = new CasaSorte(5);
        casas[15] = new CasaSorte(15);
        casas[30] = new CasaSorte(30);

        //casas magicas e de voltar ao inicio
        //casas[13] = new CasaSurpresa(13);
        casas[17] = new CasaVoltaInicio(17);
        casas[27] = new CasaVoltaInicio(27);
        casas[20] = new CasaMagica(20);
        casas[35] = new CasaMagica(35);
    }

    public Casa getCasa(int numero) {
        return casas[numero];
    }
}
