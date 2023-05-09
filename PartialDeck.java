public class PartialDeck extends Deck{
    private static Card[] cardDeck;
    private int elements = 0;

    public PartialDeck(int x) {
        cardDeck = new Card[x];
    }

    public void addToDeck(Card x) {
        cardDeck[elements] = x;
        elements++;
    }

    public void addToDeck(Card[] arrayAdd) {
        for (int i = 0; i < arrayAdd.length; i++) {
            addToDeck(arrayAdd[i]);
        }
    }

    @Override
    public Card[] getDeck() {
        return cardDeck;
    }
}
