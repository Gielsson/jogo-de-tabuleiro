package com.mycompany.jogodetabuleiro;
public class CasaSorte extends Casa {
// static = significa que este valor pertence a classe em si, n a cada objeto de casa sorte
    private static final int AVANCO = 3; //cosntante
//quem cair anda 3 casa para frente
    public CasaSorte(int numero) {
        super(numero);
    }

    
    
    public void executarEfeito(Jogo jogo, Jogador jogador) {
        //Verifica se o jogador tem direito ao bónus
        if (!jogador.recebeBonusDaSorte()) {
            System.out.println(jogador.getCor()
                    + " é azarado e não aproveita a casa da sorte. Fica onde está.");
            return;
        }
        System.out.println(jogador.getCor() + " teve sorte! Anda " + AVANCO + " casas.");
        jogador.setPosicao(jogador.getPosicao() + AVANCO);
    }
}
