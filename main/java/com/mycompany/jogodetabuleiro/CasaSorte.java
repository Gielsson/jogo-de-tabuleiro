public class CasaSorte extends Casa {

    private static final int AVANCO = 3;

    public CasaSorte(int numero) {
        super(numero);
    }

    @Override
    public void executarEfeito(Jogo jogo, Jogador jogador) {
        if (!jogador.recebeBonusDaSorte()) {
            System.out.println(jogador.getCor()
                    + " é azarado e não aproveita a casa da sorte. Fica onde está.");
            return;
        }
        System.out.println(jogador.getCor() + " teve sorte! Anda " + AVANCO + " casas.");
        jogador.setPosicao(jogador.getPosicao() + AVANCO);
    }
}
