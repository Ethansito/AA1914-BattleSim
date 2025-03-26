package org.ethansito.Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    JButton addUnitButton = new JButton();
    JButton battleButton = new JButton();

    public Menu()
    {
        // Learning how to make a GUI
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setTitle("A&A 1914 Battle Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        ImageIcon image = new ImageIcon("src/main/java/org/ethansito/logo.jpg");
        frame.setIconImage(image.getImage());
        frame.setSize(750, 750);

        JPanel army1Panel = new JPanel();
        army1Panel.setBackground(Color.RED);
        army1Panel.setPreferredSize(new Dimension(500, 700));


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2));
        centerPanel.setBackground(Color.BLACK);
        centerPanel.setPreferredSize(new Dimension(1000, 800));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.GREEN);
        titlePanel.setPreferredSize(new Dimension(100, 200));

        JPanel army2Panel = new JPanel();
        army2Panel.setBackground(Color.BLUE);
        army2Panel.setPreferredSize(new Dimension(500, 700));

        JPanel statsPanel = new JPanel();
        statsPanel.setBackground(Color.WHITE);
        statsPanel.setPreferredSize(new Dimension(400, 100));

        frame.add(centerPanel, BorderLayout.CENTER);centerPanel.add(army1Panel);centerPanel.add(army2Panel);frame.add(titlePanel, BorderLayout.NORTH);frame.add(statsPanel, BorderLayout.SOUTH);

        JLabel label = new JLabel("Axis & Allies 1914 Battle Simulator");

        ImageIcon mainMenuImage = new ImageIcon("src/main/java/org/ethansito/a&alogo.jpg");
        label.setIcon(mainMenuImage);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setForeground(Color.RED);
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        label.setVerticalAlignment(JLabel.NORTH);
        label.setHorizontalAlignment(JLabel.CENTER);

        titlePanel.add(label);


        addUnitButton.setPreferredSize(new Dimension(150, 150));
        addUnitButton.addActionListener(this);
        addUnitButton.setText("Add Unit");
        addUnitButton.setForeground(Color.BLUE);
        addUnitButton.setBackground(Color.ORANGE);
        addUnitButton.setBorder(BorderFactory.createEtchedBorder());

        statsPanel.add(addUnitButton);

        battleButton.setPreferredSize(new Dimension(150, 150));
        battleButton.setText("Fight!");
        battleButton.setForeground(Color.RED);
        battleButton.setBackground(Color.BLACK);
        battleButton.setBorder(BorderFactory.createEtchedBorder());
        battleButton.addActionListener(this);
        frame.setVisible(true);

        statsPanel.add(battleButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addUnitButton)
        {
            new AddUnitMenu();
        }

        if (e.getSource() == battleButton)
        {
            System.out.println("Pee");
        }

    }
}
