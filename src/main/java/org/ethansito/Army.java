package org.ethansito;

import org.ethansito.Frames.Stats;
import org.ethansito.Units.Land.Artillery;
import org.ethansito.Units.Land.Fighter;
import org.ethansito.Units.Land.Infantry;
import org.ethansito.Units.Land.Tank;

public class Army {
    int infantry = 0;
    int buffedInfantry = 0;
    int artillery = 0;
    int buffedArtillery = 0;
    int fighters = 0;
    int tanks = 0;
    int buffedTank = 0;
    int transports = 0;
    int submarines = 0;
    int cruisers = 0;
    int battleships = 0;
    boolean attacker;
    boolean airSup = false;
    static int[] fightersLost = {0, 0};
    Army(boolean attacker){
        this.attacker = attacker;
    }

    public int getInfantry() {
        return infantry;
    }

    public void setInfantry(int infantry) {
        this.infantry = infantry;
    }

    public int getArtillery() {
        return artillery;
    }

    public void setArtillery(int artillery) {
        this.artillery = artillery;
    }

    public int getFighters() {
        return fighters;
    }

    public void setFighters(int fighters) {
        this.fighters = fighters;
    }

    public int getTanks() {
        return tanks;
    }

    public void setTanks(int tanks) {
        this.tanks = tanks;
    }

    public int getTransports() {
        return transports;
    }

    public void setTransports(int transports) {
        this.transports = transports;
    }

    public int getSubmarines() {
        return submarines;
    }

    public void setSubmarines(int submarines) {
        this.submarines = submarines;
    }

    public int getCruisers() {
        return cruisers;
    }

    public void setCruisers(int cruisers) {
        this.cruisers = cruisers;
    }

    public int getBattleships() {
        return battleships;
    }

    public void setBattleships(int battleships) {
        this.battleships = battleships;
    }

    public boolean isAttacker(){
        return attacker;
    }

    public int getBuffedInfantry() {
        return buffedInfantry;
    }

    public void setBuffedInfantry(int buffedInfantry) {
        this.buffedInfantry = buffedInfantry;
    }

    public int getBuffedArtillery() {
        return buffedArtillery;
    }

    public void setBuffedArtillery(int buffedArtillery) {
        this.buffedArtillery = buffedArtillery;
    }

    public int getBuffedTank() {
        return buffedTank;
    }

    public void setBuffedTank(int buffedTank) {
        this.buffedTank = buffedTank;
    }

    public void landBattle(Army army2){
        int[] beforeData = {infantry, artillery, tanks, fighters, transports, submarines, cruisers, battleships,
        army2.infantry, army2.artillery, army2.tanks, army2.fighters, army2.transports, army2.submarines, army2.cruisers, army2.battleships};
        // Determine Air Superiority
        if (fighters > 0 && army2.getFighters() > 0){
            airSup = airSuperiority(army2);
        } else if (fighters > 0) {
            airSup = true;
        }

        // Buff Troops
        buffTroops();
        army2.buffTroops();

        // Expected Hits
        int army1ExHits = (int) expectedHits();
        int army2ExHits = (int) army2.expectedHits();

        // Roll the Dice
        int army1Hits = landFire();
        int army2Hits = army2.landFire();

        // Casualties Adjustment for Attacker
        int army1Casualties = Math.max(0, army2Hits - tanks - buffedTank);

        // Stats
        new Stats(beforeData, army1Hits, army2Hits, army1Casualties, army1ExHits, army2ExHits);

        // Debuff Troops and Return Fighter Casualties
        debuff();
        army2.debuff();
    }

    public boolean airSuperiority(Army army2){
        Fighter fighter = new Fighter();
        int army1hits = 0;
        int army2hits = 0;
        while (fighters > 0 && army2.getFighters() > 0){
            for (int i = 0; i < fighters; i++){
                if (fighter.attack()){
                    army1hits++;
                }
            }
            for (int i = 0; i < army2.getFighters(); i++){
                if (fighter.attack()){
                    army2hits++;
                }
            }

            fightersLost[0] = fightersLost[0] + Math.min(fighters, army2hits);
            fightersLost[1] = fightersLost[1] + Math.min(army2.getFighters(), army1hits);

            if (army1hits >= army2.getFighters()){
                army2.setFighters(0);
            } else{
                army2.setFighters(army2.getFighters() - army1hits);
            }

            if (army2hits >= fighters){
                setFighters(0);
            } else{
                setFighters(fighters - army2hits);
            }
        }

        if (army2.getFighters() > 0){
            army2.airSup = true;
            return false;
        } else return fighters > 0;
    }

    public void buffTroops(){
        int infBuffs = artillery;
        if (infantry == infBuffs){
            buffedInfantry = infantry;
            infantry = 0;
        } else if (infantry > infBuffs){
            buffedInfantry = infBuffs;
            infantry -= infBuffs;
        } else {
            buffedInfantry = infantry;
            infBuffs -= infantry;
            infantry = 0;

            if (tanks == infBuffs){
                tanks = 0;
                buffedTank = infBuffs;
            } else if (tanks > infBuffs){
                buffedTank = infBuffs;
                tanks -= infBuffs;
            } else {
                buffedTank = tanks;
            }
        }

        if (airSup){
            buffedArtillery = artillery;
            artillery = 0;
        }
    }

    public int landFire(){
        int hits = 0;
        if (infantry > 0){
            Infantry inf = new Infantry();
            hits += roll(inf, infantry);
        }
        if (buffedInfantry > 0){
            Infantry inf = new Infantry();
            inf.setAttack(inf.getAttack() + 1);
            hits += roll(inf, buffedInfantry);
        }
        if (tanks > 0){
            Tank tank = new Tank();
            hits += roll(tank, tanks);
        }
        if (buffedTank > 0){
            Tank tank = new Tank();
            tank.setAttack(tank.getAttack() + 1);
            hits += roll(tank, buffedTank);
        }
        if (artillery > 0){
            Artillery art = new Artillery();
            hits += roll(art, artillery);
        }
        if (buffedArtillery > 0){
            Artillery art = new Artillery();
            art.setAttack(art.getAttack() + 1);
            art.setDefense(art.getDefense() + 1);
            hits += roll(art, buffedArtillery);
        }
        if (fighters > 0){
            Fighter fighter = new Fighter();
            hits += roll(fighter, fighters);
        }

        return hits;
    }

    private int roll(Unit unit, int times){
        int hits = 0;
        for (int i = 0; i < times; i++){
            if (attacker){
                if (unit.attack()){hits++;}
            } else {
                if (unit.defend()) {hits++;}
            }
        }
        return hits;
    }

    public float expectedHits(){
        float hits = 0;
        if (attacker){
            hits += infantry * 0.33f;
            hits += buffedInfantry * 0.5f;
            hits += artillery * 0.5f;
            hits += buffedArtillery * 0.67f;
            hits += tanks * 0.33f;
            hits += buffedTank * 0.5f;
        } else{
            hits += infantry * 0.5f;
            hits += buffedInfantry * 0.5f;
            hits += artillery * 0.5f;
            hits += buffedArtillery * 0.67f;
            hits += tanks * 0.17f;
            hits += buffedTank * 0.17f;
        }
        hits += fighters * 0.33f;
        return hits;
    }

    public void clear(){
        setInfantry(0);
        setBuffedInfantry(0);
        setArtillery(0);
        setBuffedArtillery(0);
        setTanks(0);
        setBuffedTank(0);
        setFighters(0);
        setTransports(0);
        setSubmarines(0);
        setCruisers(0);
        setBattleships(0);
    }

    public void debuff(){
        infantry += buffedInfantry;
        buffedInfantry = 0;
        artillery += buffedArtillery;
        buffedArtillery = 0;
        tanks += buffedTank;
        buffedTank = 0;
        if (this.equals(Main.army1)){
            fighters += fightersLost[0];
            fightersLost[0] = 0;
        } else if (this.equals(Main.army2)) {
            fighters += fightersLost[1];
            fightersLost[1] = 0;
        }
    }
}
