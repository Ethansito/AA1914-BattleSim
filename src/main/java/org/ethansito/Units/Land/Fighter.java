package org.ethansito.Units.Land;

import org.ethansito.Unit;

public class Fighter extends Unit {
    static final int COST = 6;
    static int attack = 2;
    static int defense = 2;

    public Fighter(){
        super(COST, attack, defense);
    }
}
