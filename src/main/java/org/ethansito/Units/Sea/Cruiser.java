package org.ethansito.Units.Sea;

import org.ethansito.Unit;

public class Cruiser extends Unit {
    static final int COST = 9;
    static int attack = 3;
    static int defense = 3;

    public Cruiser(){
        super(COST, attack, defense);
    }

}
