package kg.geeks.game.players;

import java.util.Random;

import static kg.geeks.game.players.SuperAbility.*;

public class Thor extends Hero {
    Random random = new Random();
    boolean stunned = random.nextBoolean();

    public Thor(int health, int damage, String name) {
        super(health, damage, name, STUN);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boss.stun();
        System.out.println("Thor stuns the boss for 1 round!");
    }
}


