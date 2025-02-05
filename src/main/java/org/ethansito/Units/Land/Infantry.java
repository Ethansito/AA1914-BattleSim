package org.ethansito.Units.Land;

import org.ethansito.Unit;

public class Infantry extends Unit {
    static final int COST = 3;
    static int attack = 2;
    static int defense = 3;

    public Infantry(){
        super(COST, attack, defense);
    }
}
