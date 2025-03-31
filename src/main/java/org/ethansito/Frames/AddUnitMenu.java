package org.ethansito.Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddUnitMenu extends JFrame implements ActionListener, MouseListener {

    JLabel infantryLabel;
    JLabel artilleryLabel;
    JLabel transportLabel;
    JLabel submarineLabel;
    JLabel tankLabel;
    JLabel cruiserLabel;
    JLabel fighterLabel;
    JLabel battleshipLabel;

    AddUnitMenu(){
        JFrame addUnitFrame = new JFrame();
        addUnitFrame.setLayout(new GridLayout(4, 2));
        addUnitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addUnitFrame.setSize(new Dimension(250, 500));
        addUnitFrame.setTitle("Add Units");
        ImageIcon image = new ImageIcon("src/main/java/org/ethansito/logo.jpg");
        addUnitFrame.setIconImage(image.getImage());

        ImageIcon infantryIcon = new ImageIcon("src/main/java/org/ethansito/Units/Infantry.png");
        infantryIcon = new ImageIcon(infantryIcon.getImage().getScaledInstance(100, -100, 0));
        infantryLabel = new JLabel(infantryIcon);
        infantryLabel.addMouseListener(this);
        addUnitFrame.add(infantryLabel);
        System.out.println(infantryIcon.getIconHeight() + " " + infantryIcon.getIconWidth());

        ImageIcon transportIcon = new ImageIcon("src/main/java/org/ethansito/Units/Transport.png");
        transportIcon = new ImageIcon(transportIcon.getImage().getScaledInstance(100, -100, 0));
        transportLabel = new JLabel(transportIcon);
        transportLabel.addMouseListener(this);
        addUnitFrame.add(transportLabel);

        ImageIcon artilleryIcon = new ImageIcon("src/main/java/org/ethansito/Units/Artillery.png");
        artilleryIcon = new ImageIcon(artilleryIcon.getImage().getScaledInstance(100, -100, 0));
        artilleryLabel = new JLabel(artilleryIcon);
        artilleryLabel.addMouseListener(this);
        addUnitFrame.add(artilleryLabel);

        ImageIcon submarineIcon = new ImageIcon("src/main/java/org/ethansito/Units/Submarine.png");
        submarineIcon = new ImageIcon(submarineIcon.getImage().getScaledInstance(100, -100, 0));
        submarineLabel = new JLabel(submarineIcon);
        submarineLabel.addMouseListener(this);
        addUnitFrame.add(submarineLabel);

        ImageIcon tankIcon = new ImageIcon("src/main/java/org/ethansito/Units/Tank.png");
        tankIcon = new ImageIcon(tankIcon.getImage().getScaledInstance(100, -100, 0));
        tankLabel = new JLabel(tankIcon);
        tankLabel.addMouseListener(this);
        addUnitFrame.add(tankLabel);

        ImageIcon cruiserIcon = new ImageIcon("src/main/java/org/ethansito/Units/Cruiser.png");
        cruiserIcon = new ImageIcon(cruiserIcon.getImage().getScaledInstance(100, -100, 0));
        cruiserLabel = new JLabel(cruiserIcon);
        cruiserLabel.addMouseListener(this);
        addUnitFrame.add(cruiserLabel);

        ImageIcon fighterIcon = new ImageIcon("src/main/java/org/ethansito/Units/Fighter.png");
        fighterIcon = new ImageIcon(fighterIcon.getImage().getScaledInstance(100, -100, 0));
        fighterLabel = new JLabel(fighterIcon);
        fighterLabel.addMouseListener(this);
        addUnitFrame.add(fighterLabel);

        ImageIcon battleshipIcon = new ImageIcon("src/main/java/org/ethansito/Units/Battleship.png");
        battleshipIcon = new ImageIcon(battleshipIcon.getImage().getScaledInstance(100, -100, 0));
        battleshipLabel = new JLabel(battleshipIcon);
        battleshipLabel.addMouseListener(this);
        addUnitFrame.add(battleshipLabel);


        addUnitFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("You clicked the mouse, ");
        if (e.getSource().equals(infantryLabel))
        {
            System.out.println("and it was infantry");
        } else if (e.getSource().equals(tankLabel)){
            System.out.println("and it was a tank");
        } else{
            System.out.println("abd it was something else");
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
}
