package org.ethansito.Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUnitMenu extends JFrame implements ActionListener {

    AddUnitMenu(){
        JFrame addUnitFrame = new JFrame();
        addUnitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addUnitFrame.setSize(new Dimension(350, 750));

        addUnitFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
