package org.ethansito.Frames;

import org.ethansito.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Menu extends JFrame implements ActionListener, MouseListener {

    JButton addUnitButton = new JButton();
    JButton battleButton = new JButton();
    JCheckBox landBattleBox;
    JCheckBox seaBattleBox;
    JCheckBox ampBattleBox;
    static JPanel army1Panel;
    static JPanel army2Panel;
    static AddUnitMenu addUnitMenu;
    static JFrame menuFrame;

    static int[] army1Units = {0, 0};
    static int[] army2Units = {0, 0};

    public Menu()
    {
        // Learning how to make a GUI
        menuFrame = new JFrame();
        menuFrame.setLocation(400, 0);
        menuFrame.setLayout(new BorderLayout());
        menuFrame.setTitle("A&A 1914 Battle Simulator");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.getContentPane().setBackground(Color.BLACK);
        ImageIcon image = new ImageIcon("src/main/java/org/ethansito/logo.jpg");
        menuFrame.setIconImage(image.getImage());
        menuFrame.setSize(750, 750);

        army1Panel = new JPanel(new GridLayout(4, 4));
        army1Panel.setBackground(Color.RED);
        army1Panel.setPreferredSize(new Dimension(500, 700));

        army2Panel = new JPanel(new GridLayout(4, 4));
        army2Panel.setBackground(Color.BLUE);
        army2Panel.setPreferredSize(new Dimension(500, 700));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2));
        centerPanel.setBackground(Color.BLACK);
        centerPanel.setPreferredSize(new Dimension(1000, 800));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.GREEN);
        titlePanel.setPreferredSize(new Dimension(100, 200));

        JPanel statsPanel = new JPanel();
        statsPanel.setBackground(Color.WHITE);
        statsPanel.setPreferredSize(new Dimension(400, 100));

        menuFrame.add(centerPanel, BorderLayout.CENTER);centerPanel.add(army1Panel);centerPanel.add(army2Panel);menuFrame.add(titlePanel, BorderLayout.NORTH);menuFrame.add(statsPanel, BorderLayout.SOUTH);

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

        statsPanel.add(battleButton);

        landBattleBox = new JCheckBox();
        seaBattleBox = new JCheckBox();
        ampBattleBox = new JCheckBox();
        landBattleBox.addMouseListener(this);
        seaBattleBox.addMouseListener(this);
        ampBattleBox.addMouseListener(this);
        landBattleBox.setText("Land Battle");
        seaBattleBox.setText("Sea Battle");
        ampBattleBox.setText("Amphibious Battle");
        landBattleBox.setSelected(true);
        // These buttons are disabled until sea battles and amphibious battles are implemented
        seaBattleBox.setEnabled(false);
        ampBattleBox.setEnabled(false);
        landBattleBox.setFocusable(false);
        seaBattleBox.setFocusable(false);
        ampBattleBox.setFocusable(false);

        statsPanel.add(landBattleBox);
        statsPanel.add(seaBattleBox);
        statsPanel.add(ampBattleBox);

        menuFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addUnitButton)
        {
            addUnitMenu = new AddUnitMenu();
        }

        if (e.getSource() == battleButton)
        {
            Main.army1.landBattle(Main.army2);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(landBattleBox)) {
            seaBattleBox.setSelected(false);
            ampBattleBox.setSelected(false);
            landBattleBox.setSelected(true);
        } else if (e.getSource().equals(seaBattleBox)){
            if (!seaBattleBox.isEnabled()){return;}
            landBattleBox.setSelected(false);
            ampBattleBox.setSelected(false);
            seaBattleBox.setSelected(true);
        } else if (e.getSource().equals(ampBattleBox)){
            if (!ampBattleBox.isEnabled()){return;}
            landBattleBox.setSelected(false);
            seaBattleBox.setSelected(false);
            ampBattleBox.setSelected(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void addUnit(JLabel label){
        Icon icon = label.getIcon();
        JLabel second = new JLabel();
        second.setIcon(icon);
        if (addUnitMenu.army1Box.isSelected()) {
            army1Panel.add(second);
            if (label.equals(AddUnitMenu.infantryLabel)){
                Main.army1.setInfantry(Main.army1.getInfantry() + 1);
            } else if (label.equals(AddUnitMenu.artilleryLabel)){
                Main.army1.setArtillery(Main.army1.getArtillery() + 1);
            } else if (label.equals(AddUnitMenu.tankLabel)){
                Main.army1.setTanks(Main.army1.getTanks() + 1);
            } else if (label.equals(AddUnitMenu.fighterLabel)){
                Main.army1.setFighters(Main.army1.getFighters() + 1);
            } else if (label.equals(AddUnitMenu.transportLabel)){
                Main.army1.setTransports(Main.army1.getTransports() + 1);
            } else if (label.equals(AddUnitMenu.submarineLabel)){
                Main.army1.setSubmarines(Main.army1.getSubmarines() + 1);
            } else if (label.equals(AddUnitMenu.cruiserLabel)){
                Main.army1.setCruisers(Main.army1.getCruisers() + 1);
            } else if (label.equals(AddUnitMenu.battleshipLabel)){
                Main.army1.setBattleships(Main.army1.getBattleships() + 1);
            }
        } else{
            army2Panel.add(second);
            if (label.equals(AddUnitMenu.infantryLabel)){
                Main.army2.setInfantry(Main.army2.getInfantry() + 1);
            } else if (label.equals(AddUnitMenu.artilleryLabel)){
                Main.army2.setArtillery(Main.army2.getArtillery() + 1);
            } else if (label.equals(AddUnitMenu.tankLabel)){
                Main.army2.setTanks(Main.army2.getTanks() + 1);
            } else if (label.equals(AddUnitMenu.fighterLabel)){
                Main.army2.setFighters(Main.army2.getFighters() + 1);
            } else if (label.equals(AddUnitMenu.transportLabel)){
                Main.army2.setTransports(Main.army2.getTransports() + 1);
            } else if (label.equals(AddUnitMenu.submarineLabel)){
                Main.army2.setSubmarines(Main.army2.getSubmarines() + 1);
            } else if (label.equals(AddUnitMenu.cruiserLabel)){
                Main.army2.setCruisers(Main.army2.getCruisers() + 1);
            } else if (label.equals(AddUnitMenu.battleshipLabel)){
                Main.army2.setBattleships(Main.army2.getBattleships() + 1);
            }
        }
        menuFrame.revalidate();
        menuFrame.repaint();
    }
}
