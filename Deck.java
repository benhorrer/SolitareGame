import java.util.Random;

public class Deck {
    private static Card[] cardDeck = new Card[52];
    private static Card[] freshDeck;


    public Deck() {
        int counter = 0;
        for (int setSuite = 1; setSuite <= 4; setSuite++) {
            for (int setNum = 1; setNum <= 13; setNum++) {
                cardDeck[counter] = new Card(setSuite, setNum);
                counter++;
            }
        }
        freshDeck = cardDeck;

    }

    public void shuffle(Card[] shuffleDeck) {
        Random shuffler = new Random();
        for (int i = 0; i < 1000; i++) {
            int x = shuffler.nextInt(52);
            int y = shuffler.nextInt(52);
            Card temp = shuffleDeck[x];
            shuffleDeck[x] = shuffleDeck[y];
            shuffleDeck[y] = temp;
        }
    }

    public void print() {
        for(Card x : cardDeck) {
            System.out.printf("%s of %s\n", x.getValueName(), x.getSuiteName());
        }
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        Deck testDeck = new Deck();
        testDeck.print();
        testDeck.shuffle(cardDeck);
        testDeck.print();
        testDeck.shuffle(cardDeck);
        testDeck.print();
        testDeck.shuffle(cardDeck);
        testDeck.print();
        testDeck.shuffle(cardDeck);
    }

}
