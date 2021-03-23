package cz.educanet.arena.logic;

import java.util.Random;

public class Gladiator {

    private static Random random = new Random();

    /**
     * Name of the gladiator
     */
    private String name;
    private int hp = random.nextInt(150 - 100) + 100;
    private int dmgGlad;




    // TODO: Add the rest of the properties
    // TODO: Generate/create getters and setters for these properties



    /**
     * @return true if hp is <= 0, else false
     */
    public boolean isDead() {
        // TODO:
        if (hp <= 0){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Generates a random value between min. damage and max. damage and deals it to the enemy.
     * @param enemy Enemy gladiator
     */





    public void dealDamage(Gladiator enemy) {
        // TODO:
        // Generate the random value, that the gladiator will deal.


        int low = 20;
        int high = 40;

        int damageMin = random.nextInt(15);
        int damageMax = random.nextInt(high - low) + low;

        setDmgGlad(damageMax - damageMin);

        enemy.setHp(enemy.getHp() - dmgGlad);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDmgGlad() {
        return dmgGlad;
    }
    public void setDmgGlad(int dmgGlad) {
        this.dmgGlad = dmgGlad;
    }
}
