package org.ethansito.Units.Sea;

import org.ethansito.Unit;

public class Battleship extends Unit {
    static final int COST = 12;
    static int attack = 4;
    static int defense = 4;

    public Battleship(){
        super(COST, attack, defense);
    }
}
