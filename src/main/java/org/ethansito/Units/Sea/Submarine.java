package org.ethansito.Units.Sea;

import org.ethansito.Unit;

public class Submarine extends Unit {
    static final int COST = 6;
    static int attack = 2;
    static int defense = 2;

    public Submarine(){
        super(COST, attack, defense);
    }
}
