import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUI implements ActionListener, MouseListener, MouseMotionListener {
    private int currentCount = 1;
    private int currentshuffles = 0;
    private JFrame frame;
    private JLabel shuffleLabel;
    private JLabel nextCardLabel;
    private JLabel currentCardLabel;
    private JLabel dragableCard;
    private JPanel nextCardPanel;
    private JPanel currentCardPanel;
    private JPanel shufflePanel;   
    private JPanel dragCardPanel;
    private JButton card;
    private JButton nextCard;
    private JButton shuffle;
    private Deck gameDeck;
    private ImageIcon current;
    private ImageIcon hiddenCard;
    private ImageIcon nextIcon;

    private Point startPoint;

    public GUI() {
        gameDeck = new Deck();
       try { 
        hiddenCard = new ImageIcon(gameDeck.getDeck()[0].getAssetString());
        nextIcon = hiddenCard;
        }
        catch (Exception e) { System.out.println("Image cannot be found"); }
        frame = new JFrame();
        shufflePanel = new JPanel();
        nextCardPanel = new JPanel();
        currentCardPanel = new JPanel();
        dragCardPanel = new JPanel();



        shuffleLabel = new JLabel("Times Shuffled: 0");
        nextCardLabel = new JLabel();
        currentCardLabel = new JLabel();


        card = new JButton("Current Card", hiddenCard);
        nextCard = new JButton("Get Next Card", hiddenCard);
        shuffle = new JButton("Click me \nto shuffle", new ImageIcon("../assets/cards/shuffle.png"));

        card.addActionListener(this);
        nextCard.addActionListener(this);
        shuffle.addActionListener(this);
        
        shuffle.setBorder(BorderFactory.createEmptyBorder(20, 20, 15, 20));
        nextCard.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        card.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        
        nextCardPanel.add("Get next card", nextCard);
        nextCardPanel.add(nextCardLabel);
        shufflePanel.add(shuffle);
        shufflePanel.add(shuffleLabel);
        currentCardPanel.add(card);
        currentCardPanel.add(currentCardLabel);


        
        frame.add(shufflePanel, BorderLayout.EAST);
        frame.add(currentCardPanel, BorderLayout.CENTER);
        frame.add(nextCardPanel, BorderLayout.WEST);
        frame.add(dragCardPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Solitare");
        frame.pack();
        frame.setVisible(true);

        frame.setLocationRelativeTo(null);
    }

    

    public static void main(String[] args) {
        new GUI();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Card[] modify = gameDeck.getDeck();
        if (e.getSource() == shuffle) {
            //String file = modify[0].getAssetString();
            //hiddenCard = new ImageIcon(file);
            //shuffleLabel.setIcon(new ImageIcon("shuffle.png"));
            nextIcon = hiddenCard;
            //card.setIcon(hiddenCard);
            currentshuffles++;
            shuffleLabel.setText("Times shuffled: " +  currentshuffles);


            //maybe
            //
            //gameDeck.shuffle(gamedeck.getDeck());

            gameDeck.shuffle(modify);
            currentCount = 0;
            card.setIcon(nextIcon);
        }
        else if (e.getSource() == nextCard) {
            //String file = modify[currentCount + 1].getAssetString();
            if (currentCount < 52) {
                //System.out.println(modify[currentCount].getAssetString());
                nextIcon = new ImageIcon(modify[currentCount].getAssetString());
                currentCount++;
                //currentCardLabel.setIcon(current);
                System.out.println(currentCount);
                //nextCardLabel.setIcon(new ImageIcon("S1.png"));
                card.setIcon(nextIcon);

            }
            else {
                nextIcon = hiddenCard;
            }
        }
        else if (e.getSource() == card) {
            ImageIcon dragIcon = new ImageIcon(modify[currentCount].getAssetString());
            if (currentCount > 0) nextIcon = new ImageIcon(modify[currentCount - 1].getAssetString());
            dragableCard = new JLabel(dragIcon);
            dragableCard.setVisible(true);
            dragableCard.addMouseListener(this);
            dragableCard.addMouseMotionListener(this);
            dragCardPanel.add(dragableCard);
            dragCardPanel.revalidate();
            dragCardPanel.repaint();
            

        }
        //try {
        //card.setIcon(nextIcon);
        //}
        //catch (Exception x) { System.out.println("Image cannot be found"); }
    }



    @Override
    public void mouseDragged(MouseEvent e) {
        Point location = SwingUtilities.convertPoint(dragableCard, e.getPoint(), frame);
        if (frame.getBounds().contains(location)) {
            Point newLocation = dragableCard.getLocation();
            newLocation.translate(location.x - startPoint.x , location.y - startPoint.y);
            newLocation.x = Math.max(newLocation.x, 0);
            newLocation.y = Math.max(newLocation.y, 0);
            newLocation.x = Math.min(newLocation.x, frame.getWidth() - dragableCard.getWidth());
            newLocation.y = Math.min(newLocation.y, frame.getHeight() - dragableCard.getHeight());
            dragableCard.setLocation(newLocation);
            startPoint = location;
        }

    }



    @Override
    public void mouseMoved(MouseEvent e) {
    }



    @Override
    public void mouseClicked(MouseEvent e) {
    }



    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = SwingUtilities.convertPoint(frame, e.getPoint(), frame);
    }



    @Override
    public void mouseReleased(MouseEvent e) {
        startPoint = null;
    }



    @Override
    public void mouseEntered(MouseEvent e) {
    }



    @Override
    public void mouseExited(MouseEvent e) {
    }
}
