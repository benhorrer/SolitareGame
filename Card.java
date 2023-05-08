public class Card {
    private int suite;
    private String suiteName;
    private int value;
    private String numberToString;

    public Card(int suite, int value) {
        setSuite(suite);
        setValue(value);
    }

    public int getSuite() {
        return suite;
    }

    public int getValue() {
        return value;
    }

    public String getSuiteName() {
        return suiteName;
    }

    public String getValueName() {
        return numberToString;
    }

    public void setSuite(int _suite) {
        switch (_suite) {
            case 1:
                suite = 1;
                suiteName = "Spades";
                break;
            case 2:
                suite = 2;
                suiteName = "Clubs";
                break;
            case 3:
                suite = 3;
                suiteName = "Hearts";
                break;
            case 4: 
                suite = 4;
                suiteName = "Diamonds";
                break;
            default:
                suite = 0;
                suiteName = "Null";
                break;
        }
    }

    public void setValue(int val) {
        switch (val) {
            case 1:
                value = val;
                numberToString = "Ace";
                break;
            case 2:
                value = val;
                numberToString = "Two";
                break;
            case 3:
                value = val;
                numberToString = "Three";
                break;
            case 4:
                value = val;
                numberToString = "Four";
                break;
            case 5:
                value = val;
                numberToString = "Five";
                break;
            case 6:
                value = val;
                numberToString = "Six";
                break;
            case 7:
                value = val;
                numberToString = "Seven";
                break;
            case 8:
                value = val;
                numberToString = "Eight";
                break;
            case 9:
                value = val;
                numberToString = "Nine";
                break;
            case 10:
                value = val;
                numberToString = "Ten";
                break;
            case 11:
                value = val;
                numberToString = "Jack";
                break;
            case 12: 
                value = val;
                numberToString = "Queen";
                break;
            case 13:
                value = val;
                numberToString = "King";
                break;
            default:
                val = 0;
                numberToString = "Null";
                break;
        }
    }
}