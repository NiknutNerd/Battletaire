/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group7.battletaire;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Stack;
import javax.swing.*;

/**
 *
 * @author johnm
 */
public class GameBoard extends JComponent implements MouseListener {
    private static final int CARD_WIDTH = 242/2;
    private static final int CARD_HEIGHT = 338/2;
    private static final int SPACING = 30;
    private static final int FACE_UP_OFFSET = 90;
    private static final int FACE_DOWN_OFFSET = 30;

    private JFrame frame;
    private int selectedRow = -1;
    private int selectedCol = -1;
    private Battletaire game;
    private Stack<Card>[] piles;
    private Stack<Card>[] foundations;
    private Stack<Card> stock;
    private Stack<Card> dump;

    public GameBoard(Battletaire game, Stack<Card>[] piles, Stack<Card>[] foundations, Stack<Card> stock, Stack<Card> dump) {
        this.game = game;
        this.piles = piles;
        this.foundations = foundations;
        this.stock = stock;
        this.dump = dump;

        frame = new JFrame("Battletaire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);

        //this.setPreferredSize(new Dimension(CARD_WIDTH * 7 + SPACING * 8, CARD_HEIGHT * 2 + SPACING * 3 + FACE_DOWN_OFFSET * 7 + 13 * FACE_UP_OFFSET));
        this.setPreferredSize(new Dimension(1920, 1080));
        this.addMouseListener(this);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        setOpaque(false);
        // Draw sackground Image
        Image backgroundImage = new ImageIcon("PlayingCards/Background.png").getImage();
        if(backgroundImage == null)
            System.out.println("Background DNE");
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        // Draw stock
        drawCard(g, stock.isEmpty() ? null : stock.peek(), SPACING, SPACING);

        // Draw dump
        drawCard(g, dump.isEmpty() ? null : dump.peek(), SPACING * 2 + CARD_WIDTH, SPACING);
        if (selectedRow == 0 && selectedCol == 1)
            drawBorder(g, SPACING * 2 + CARD_WIDTH, SPACING);

        // Draw foundations
        for (int i = 0; i < 4; i++) {
            drawCard(g, foundations[i].isEmpty() ? null : foundations[i].peek(), SPACING * (4 + i) + CARD_WIDTH * (3 + i), SPACING);
        }

        // Draw piles
        for (int i = 0; i < 7; i++) {
            int offset = 0;
            for (int j = 0; j < piles[i].size(); j++) {
                Card card = piles[i].get(j);
                drawCard(g, card, SPACING + (CARD_WIDTH + SPACING) * i, CARD_HEIGHT + 2 * SPACING + offset);
                if (card.faceUp)
                    offset += FACE_UP_OFFSET;
                else
                    offset += FACE_DOWN_OFFSET;
            }
        }
    }

    private void drawCard(Graphics g, Card card, int x, int y) {
        if (card == null) {
            g.setColor(Color.BLACK);
            g.drawRect(x, y, CARD_WIDTH, CARD_HEIGHT);
        } else {
            String fileName = getFileName(card);
            if (!new File(fileName).exists()) {
                g.setColor(Color.RED);
                g.drawRect(x, y, CARD_WIDTH, CARD_HEIGHT);
                g.drawString("Missing", x + 10, y + 50);
                System.out.println("File "+fileName+" DNE");
            } else {
                Image image = new ImageIcon(fileName).getImage();
                g.drawImage(image, x, y, CARD_WIDTH, CARD_HEIGHT, null);
            }
        }
    }

    private String getFileName(Card card) {
        String value = card.value.name();
        String suit = card.suit.name();
        return "PlayingCards/" + value + "_" + suit + ".png";
    }

    private void drawBorder(Graphics g, int x, int y) {
        g.setColor(Color.YELLOW);
        g.drawRect(x, y, CARD_WIDTH, CARD_HEIGHT);
        g.drawRect(x + 1, y + 1, CARD_WIDTH - 2, CARD_HEIGHT - 2);
        g.drawRect(x + 2, y + 2, CARD_WIDTH - 4, CARD_HEIGHT - 4);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int col = e.getX() / (SPACING + CARD_WIDTH);
        int row = e.getY() / (SPACING + CARD_HEIGHT);
        if (row == 0 && col == 0) {
            // Stock clicked
            Battletaire.checkStock(stock, dump);
        } else if (row == 0 && col == 1) {
            // Dump clicked
       
        } else if (row == 1) {
            // Piles clicked
            
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
