public class Solitare {
    private static Card[] extraDeck;
    private static Card[] original;
    private static Deck[][] playedCards = new Card[7][13];
    private static int dealCounter = 0;

    public Solitare() {
        Deck x = new Deck();
        x.shuffle(x.getDeck());
        x.shuffle(x.getDeck());
        x.shuffle(x.getDeck());
        for (int i = 0; i < 28; i++) {
            original[i] = x.getDeck()[i];
            extraDeck[i] = x.getDeck()[i+28];
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < i; j++, dealCounter++)
            {
                playedCards[i][j] = original[dealCounter];
            }
        }
    }

    public static void main (String[] args) {
        Solitare newGame = new Solitare();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < i; j++) {
                System.out.println(playedCards[i][j].print());
                }
            }
        }
    }
}
