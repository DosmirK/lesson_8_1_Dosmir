package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

import java.util.Random;


public class Boss extends GameEntity {
    private SuperAbility defence;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public SuperAbility getDefence() {
        return defence;
    }

    public void chooseDefence() {
        SuperAbility[] values = SuperAbility.values();
        int randomIndex = RPG_Game.random.nextInt(values.length); // 0,1,2,3
        this.defence = values[randomIndex];
    }

    public void attack(Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 ) {
                if (heroes[i] instanceof Berserk && this.defence != SuperAbility.BLOCK_DAMAGE_AND_REVERT) {
                    ((Berserk) heroes[i]).setBlockedDamage(this.getDamage() / 5);
                    heroes[i].setHealth(heroes[i].getHealth() -
                            (this.getDamage() - ((Berserk) heroes[i]).getBlockedDamage()));
                } else {
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
                }
            }
        }
    }


    @Override
    public String toString() {
        return super.toString() + " defence: " + this.defence;
    }
    public void stun() {
        this.setDamage(50);
        Random random = new Random();
        boolean stun = random.nextBoolean();
        if (stun) {
            this.setDamage(0);
        }
    }
}
