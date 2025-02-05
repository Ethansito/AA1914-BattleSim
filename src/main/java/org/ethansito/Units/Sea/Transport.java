package org.ethansito.Units.Sea;

import org.ethansito.Unit;

public class Transport extends Unit {
    static final int COST = 6;
    static int attack = 0;
    static int defense = 0;

    public Transport(){
        super(COST, attack, defense);
    }
}
