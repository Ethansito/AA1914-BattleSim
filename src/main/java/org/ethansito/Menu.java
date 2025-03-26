package org.ethansito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    Menu()
    {
        // Learning how to make a GUI
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("A&A 1914 Battle Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        ImageIcon image = new ImageIcon("src/main/java/org/ethansito/logo.jpg");
        frame.setIconImage(image.getImage());
        frame.setSize(750, 750);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(0, 0, 100, 100);
        JPanel greenPanel = new JPanel();
        greenPanel.setBounds(100,100,100,100);
        greenPanel.setBackground(Color.GREEN);
        JPanel bluePanel = new JPanel();
        bluePanel.setBounds(200, 200, 200, 200);
        bluePanel.setBackground(Color.BLUE);

        frame.add(redPanel);frame.add(bluePanel);frame.add(greenPanel);

        JLabel label = new JLabel("Axis & Allies 1914 Battle Simulator");

        ImageIcon mainMenuImage = new ImageIcon("src/main/java/org/ethansito/a&alogo.jpg");
        label.setIcon(mainMenuImage);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setForeground(Color.RED);
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        label.setVerticalAlignment(JLabel.NORTH);
        label.setHorizontalAlignment(JLabel.CENTER);

        bluePanel.add(label);

        JButton button = new JButton();
        button.setBounds(375, 375, 100, 50);
        button.addActionListener(this);
        button.setText("Add Unit");
        button.setForeground(Color.BLUE);
        button.setBackground(Color.ORANGE);
        button.setBorder(BorderFactory.createEtchedBorder());

        frame.add(button);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Poo");
    }
}
