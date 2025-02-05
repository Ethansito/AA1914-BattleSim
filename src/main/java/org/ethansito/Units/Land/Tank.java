package org.ethansito.Units.Land;

import org.ethansito.Unit;

public class Tank extends Unit {
    static final int COST = 6;
    static int attack = 2;
    static int defense = 1;

    Tank(){
        super(COST, attack, defense);
    }
}
