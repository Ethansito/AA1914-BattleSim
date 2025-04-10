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
    public boolean attack(){
        int roll = rand.nextInt(1,7);
        return roll <= attack;
    }

    public boolean defend(){
        int roll = rand.nextInt(1,7);
        return roll <= defense;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
