import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener {
    private int currentCount = 1;
    private int currentshuffles = 0;
    private JFrame frame;
    private JLabel shuffleLabel;
    private JLabel nextCardLabel;
    private JLabel currentCardLabel;
    private JPanel nextCardPanel;
    private JPanel currentCardPanel;
    private JPanel shufflePanel;    
    private JButton card;
    private JButton nextCard;
    private JButton shuffle;
    private Deck gameDeck;
    private ImageIcon current;
    private ImageIcon hiddenCard;

    public GUI() {
        gameDeck = new Deck();
       try { 
        hiddenCard = new ImageIcon("N0.png");
        //System.out.println(getClass().getResource("../assets/cards/N0"));
        current = new ImageIcon("N0.png");
        }
        catch (Exception e) { System.out.println("Image cannot be found"); }
        frame = new JFrame();
        shufflePanel = new JPanel();
        nextCardPanel = new JPanel();
        currentCardPanel = new JPanel();


        shuffleLabel = new JLabel("Times Shuffled: 0");
        nextCardLabel = new JLabel(hiddenCard);
        currentCardLabel = new JLabel(current);


        card = new JButton("Current Card", current);
        nextCard = new JButton("Get Next Card", new ImageIcon("N0.png"));
        shuffle = new JButton("Click me \nto shuffle", new ImageIcon("shuffle.png"));

        card.addActionListener(this);
        nextCard.addActionListener(this);
        shuffle.addActionListener(this);
        
        shuffle.setBorder(BorderFactory.createEmptyBorder(250, 250, 250, 250));
        nextCard.setBorder(BorderFactory.createEmptyBorder(250, 500, 250, 500));
        card.setBorder(BorderFactory.createEmptyBorder(250, 750, 250, 750));
        
        nextCardPanel.add("Get next card", nextCard);
        nextCardPanel.add(nextCardLabel);
        shufflePanel.add(shuffle);
        shufflePanel.add(shuffleLabel);
        currentCardPanel.add(card);
        currentCardPanel.add(currentCardLabel);


        
        frame.add(shufflePanel, BorderLayout.EAST);
        frame.add(currentCardPanel, BorderLayout.CENTER);
        frame.add(nextCardPanel, BorderLayout.WEST);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Solitare");
        frame.pack();
        frame.setVisible(true);
    }

    

    public static void main(String[] args) {
        new GUI();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Card[] modify = gameDeck.getDeck();
        if (e.getSource() == shuffle) {
            hiddenCard = new ImageIcon(modify[0].getAssetString());
            shuffleLabel.setIcon(new ImageIcon("shuffle.png"));
            card.setIcon(hiddenCard);
            currentshuffles++;
            shuffleLabel.setText("Times shuffled: " +  currentshuffles);


            //maybe
            //
            //gameDeck.shuffle(gamedeck.getDeck());

            gameDeck.shuffle(modify);
            currentCount = 0;
        }
        else if (e.getSource() == nextCard) {
            System.out.println(modify[currentCount + 1].getAssetString());
            if (currentCount + 1 < 52) {
                ImageIcon nextCard = new ImageIcon(modify[currentCount + 1].getAssetString());
                currentCount++;
                currentCardLabel.setIcon(nextCard);
                System.out.println(currentCount);
                //nextCardLabel.setIcon(new ImageIcon("S1.png"));

            }
            else {
                hiddenCard = new ImageIcon(modify[0].getAssetString());
                nextCardLabel = new JLabel(hiddenCard);
            }
        }
    }
}
