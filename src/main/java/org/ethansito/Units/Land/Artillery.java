package org.ethansito.Units.Land;

import org.ethansito.Unit;

public class Artillery extends Unit {

    static final int COST = 4;
    static int attack = 3;
    static int defense = 3;
    public Artillery(){
        super(COST, attack, defense);
    }
}
