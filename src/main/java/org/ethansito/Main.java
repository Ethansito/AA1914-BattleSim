package org.ethansito;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    public static Random rand = new Random();
    private static Random getRand(){return rand;}

    public static void main(String[] args) {
        // Learning how to make a GUI
        JFrame frame = new JFrame();
        frame.setTitle("A&A 1914 Battle Simulator");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        ImageIcon image = new ImageIcon("src/main/java/org/ethansito/logo.jpg");
        frame.setIconImage(image.getImage());

        JLabel label = new JLabel("Axis & Allies 1914 Battle Simulator");
        frame.add(label);
        ImageIcon mainMenuImage = new ImageIcon("src/main/java/org/ethansito/a&alogo.jpg");
        label.setIcon(mainMenuImage);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setForeground(Color.RED);
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        label.setVerticalAlignment(JLabel.NORTH);
        label.setHorizontalAlignment(JLabel.CENTER);

        frame.pack();
    }
}