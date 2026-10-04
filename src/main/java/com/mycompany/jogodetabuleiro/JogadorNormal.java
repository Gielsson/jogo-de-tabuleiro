package com.mycompany.jogodetabuleiro;

// o jog comum rola os dados normalmente, a soma pode ser alta ou baixa
public class JogadorNormal extends Jogador {

    public JogadorNormal(String cor) {
        super(cor); // manda a cor para a classe Jogador guardar
    }

    // Usado na casa surpresa: vira Normal mantendo cor, posicao e jogadas
    public JogadorNormal(Jogador outro) {
        super(outro);
    }

    public void rolarDados(Dados dados) {
        dados.rolar(); // rolagem simples
    }

    public String getTipo() {
        return "Normal";
    }
}
