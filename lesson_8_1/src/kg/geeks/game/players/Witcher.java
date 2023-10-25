package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Witcher extends Hero {


    public Witcher(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.RESURRECTION);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= 0 && this != heroes[i]) {
                heroes[i].setHealth(heroes[i].getHealth() + this.getHealth());
                this.setHealth(0);
                System.out.println("Witcher " + this.getName() + " used RESURRECTION on " + heroes[i].getName());
            }
        }
    }
}
