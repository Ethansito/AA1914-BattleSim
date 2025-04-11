package org.ethansito.Frames;

import org.ethansito.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class AddUnitMenu extends JFrame implements ActionListener, MouseListener {

    public static JLabel infantryLabel;
    public static JLabel artilleryLabel;
    public static JLabel transportLabel;
    public static JLabel submarineLabel;
    public static JLabel tankLabel;
    public static JLabel cruiserLabel;
    public static JLabel fighterLabel;
    public static JLabel battleshipLabel;
    JCheckBox army1Box;
    JCheckBox army2Box;
    ArrayList<JLabel> labels = new ArrayList<>();

    AddUnitMenu(){
        JFrame addUnitFrame = new JFrame();
        addUnitFrame.setLocation(160, 0);
        addUnitFrame.setLayout(new BorderLayout());
        addUnitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addUnitFrame.setSize(new Dimension(250, 750));
        addUnitFrame.setTitle("Add Units");
        ImageIcon image = new ImageIcon("src/main/java/org/ethansito/logo.jpg");
        addUnitFrame.setIconImage(image.getImage());

        JPanel topPanel = new JPanel();
        army1Box = new JCheckBox();
        army2Box = new JCheckBox();
        army1Box.setFocusable(false);
        army2Box.setFocusable(false);
        army1Box.addMouseListener(this);
        army2Box.addMouseListener(this);
        army1Box.setText("Red Army");
        army2Box.setText("Blue Army");
        army1Box.setSelected(true);
        topPanel.add(army1Box);
        topPanel.add(army2Box);
        topPanel.setSize(0, 75);
        addUnitFrame.add(topPanel, BorderLayout.NORTH);

        JPanel unitPanel = new JPanel(new GridLayout(4, 2));
        addUnitFrame.add(unitPanel, BorderLayout.CENTER);

        ImageIcon infantryIcon = new ImageIcon("src/main/java/org/ethansito/Units/Infantry.png");
        infantryIcon = new ImageIcon(infantryIcon.getImage().getScaledInstance(100, -100, 0));
        infantryLabel = new JLabel(infantryIcon);
        infantryLabel.addMouseListener(this);
        alignLabel(infantryLabel, "Infantry");
        unitPanel.add(infantryLabel);
        System.out.println(infantryIcon.getIconHeight() + " " + infantryIcon.getIconWidth());

        ImageIcon transportIcon = new ImageIcon("src/main/java/org/ethansito/Units/Transport.png");
        transportIcon = new ImageIcon(transportIcon.getImage().getScaledInstance(100, -100, 0));
        transportLabel = new JLabel(transportIcon);
        transportLabel.addMouseListener(this);
        alignLabel(transportLabel, "Transport");
        unitPanel.add(transportLabel);

        ImageIcon artilleryIcon = new ImageIcon("src/main/java/org/ethansito/Units/Artillery.png");
        artilleryIcon = new ImageIcon(artilleryIcon.getImage().getScaledInstance(100, -100, 0));
        artilleryLabel = new JLabel(artilleryIcon);
        artilleryLabel.addMouseListener(this);
        alignLabel(artilleryLabel, "Artillery");
        unitPanel.add(artilleryLabel);

        ImageIcon submarineIcon = new ImageIcon("src/main/java/org/ethansito/Units/Submarine.png");
        submarineIcon = new ImageIcon(submarineIcon.getImage().getScaledInstance(100, -100, 0));
        submarineLabel = new JLabel(submarineIcon);
        submarineLabel.addMouseListener(this);
        alignLabel(submarineLabel, "Submarine");
        unitPanel.add(submarineLabel);

        ImageIcon tankIcon = new ImageIcon("src/main/java/org/ethansito/Units/Tank.png");
        tankIcon = new ImageIcon(tankIcon.getImage().getScaledInstance(100, -100, 0));
        tankLabel = new JLabel(tankIcon);
        tankLabel.addMouseListener(this);
        alignLabel(tankLabel, "Tank");
        unitPanel.add(tankLabel);

        ImageIcon cruiserIcon = new ImageIcon("src/main/java/org/ethansito/Units/Cruiser.png");
        cruiserIcon = new ImageIcon(cruiserIcon.getImage().getScaledInstance(100, -100, 0));
        cruiserLabel = new JLabel(cruiserIcon);
        cruiserLabel.addMouseListener(this);
        alignLabel(cruiserLabel, "Cruiser");
        unitPanel.add(cruiserLabel);

        ImageIcon fighterIcon = new ImageIcon("src/main/java/org/ethansito/Units/Fighter.png");
        fighterIcon = new ImageIcon(fighterIcon.getImage().getScaledInstance(100, -100, 0));
        fighterLabel = new JLabel(fighterIcon);
        fighterLabel.addMouseListener(this);
        alignLabel(fighterLabel, "Fighter");
        unitPanel.add(fighterLabel);

        ImageIcon battleshipIcon = new ImageIcon("src/main/java/org/ethansito/Units/Battleship.png");
        battleshipIcon = new ImageIcon(battleshipIcon.getImage().getScaledInstance(100, -100, 0));
        battleshipLabel = new JLabel(battleshipIcon);
        battleshipLabel.addMouseListener(this);
        alignLabel(battleshipLabel, "Battleship");
        unitPanel.add(battleshipLabel);

        labels.add(infantryLabel); labels.add(artilleryLabel); labels.add(tankLabel); labels.add(fighterLabel);
        labels.add(transportLabel); labels.add(submarineLabel); labels.add(cruiserLabel); labels.add(battleshipLabel);
        addUnitFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JLabel){
            if (labels.contains((JLabel) e.getSource()))
            {
                if (verify((JLabel) e.getSource())){
                    Menu.addUnit((JLabel) e.getSource());
                }
            }
        }
        else if (e.getSource().equals(army1Box)) {
            army2Box.setSelected(false);
            army1Box.setSelected(true);

        } else if (e.getSource().equals(army2Box)){
            army1Box.setSelected(false);
            army2Box.setSelected(true);
        } else{
            System.out.println("and it was something else");
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

    public void alignLabel(JLabel label, String text) {
        label.setText(text);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
    }

    public boolean verify(JLabel label){
        // This will check if the unit can be added to this battle
        if (label.equals(infantryLabel) || label.equals(artilleryLabel) || label.equals(tankLabel) || label.equals(fighterLabel)){
            return !(Main.menu.seaBattleBox.isSelected());
        } else if (label.equals(transportLabel) || label.equals(submarineLabel) || label.equals(cruiserLabel) || label.equals(battleshipLabel)){
            return !(Main.menu.landBattleBox.isSelected());
        }
        return false;
    }

}
