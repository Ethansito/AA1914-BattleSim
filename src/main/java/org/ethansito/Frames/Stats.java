package org.ethansito.Frames;

import javax.swing.*;
import java.awt.*;

public class Stats extends JFrame {
    JFrame statsFrame;
    JPanel buildPanel;
    JTextArea buildTextArea;
    JPanel hitsPanel;
    JTextArea hitsTextArea;
    JPanel casualtiesPanel;
    JTextArea casualtiesTextArea;
//    JPanel ecoPanel;
//    JTextArea ecoTextArea;
    public Stats(int[] bfData, int army1Hits, int army2Hits, int army1Casualties, int army1ExHits, int army2ExHits){
        statsFrame = new JFrame();
        statsFrame.setLayout(new GridLayout(3, 1));
        statsFrame.setLocation(800,0);
        statsFrame.setSize(250, 600);
        ImageIcon image = new ImageIcon("src/main/java/org/ethansito/logo.jpg");
        statsFrame.setIconImage(image.getImage());

        String armyString = String.format("""
                        Army Composition
                Red Army             Blue Army
                ----------------------------------
                Infantry: %d         Infantry: %d
                Artillery: %d        Artillery: %d
                Tank: %d             Tank: %d
                Fighter: %d          Fighter: %d
                Transport: %d        Transport: %d
                Submarine: %d        Submarine: %d
                Cruiser: %d          Cruiser: %d
                Battleship: %d       Battleship: %d
                """, bfData[0], bfData[8], bfData[1], bfData[9], bfData[2], bfData[10], bfData[3], bfData[11], bfData[4],
                bfData[12], bfData[5], bfData[13], bfData[6], bfData[14], bfData[7], bfData[15]);
        buildTextArea = new JTextArea(armyString);
        buildTextArea.setFocusable(false);

        buildPanel = new JPanel(new BorderLayout());
        buildPanel.add(buildTextArea, BorderLayout.CENTER);



        hitsPanel = new JPanel(new BorderLayout());
        String hitsString = String.format("""
                
               
                
                              Hits
                Red Army             Blue Army
                ----------------------------------
                Total Hits: %d       Total Hits: %d
                Expected Hits: %d     Expected Hits: %d
                """, army1Hits, army2Hits, army1ExHits, army2ExHits);
        hitsTextArea = new JTextArea(hitsString);
        hitsTextArea.setFocusable(false);
        hitsPanel.add(hitsTextArea, BorderLayout.CENTER);

        casualtiesPanel = new JPanel(new BorderLayout());
        String casualtiesString = String.format("""
                              Casualties
                Red Army                  Blue Army
                ------------------------------------
                %d                         %d
                """, army1Casualties, army1Hits);
        casualtiesTextArea = new JTextArea(casualtiesString);
        casualtiesTextArea.setFocusable(false);
        casualtiesPanel.add(casualtiesTextArea);

//        ecoPanel = new JPanel(new BorderLayout());
//        String ecoString = String.format("""
//                             Economic Damage
//                Red Army                     Blue Army
//                ---------------------------------------
//                %d                           %d
//                """);

        statsFrame.add(buildPanel);
        statsFrame.add(hitsPanel);
        statsFrame.add(casualtiesPanel);
//        statsFrame.add(ecoPanel);


        statsFrame.setVisible(true);
    }
}
