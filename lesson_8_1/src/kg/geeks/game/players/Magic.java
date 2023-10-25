package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Magic extends Hero {
    public Magic(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coeff = RPG_Game.random.nextInt(2) + 2; // 0,1,2
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage() * coeff);
                System.out.println("Mage " + this.getName() + " used BOOST " + coeff);

            }
        }
    }
}
