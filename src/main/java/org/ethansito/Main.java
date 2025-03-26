package org.ethansito;

import org.ethansito.Frames.Menu;

import java.util.Random;

public class Main {
    public static Random rand = new Random();
    private static Random getRand(){return rand;}

    public static void main(String[] args) {

        new Menu();
    }
}