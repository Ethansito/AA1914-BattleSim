package org.ethansito;

import static org.ethansito.Main.rand;

public class Unit {
    int cost;
    int attack;
    int defense;

    public Unit(int cost, int attack, int defense){
        this.cost = cost;
        this.attack = attack;
        this.defense = defense;
    }
    boolean attack(){
        int roll = rand.nextInt(1,7);
        return roll <= attack;
    }

    boolean defend(){
        int roll = rand.nextInt(1,7);
        return roll <= defense;
    }
}
