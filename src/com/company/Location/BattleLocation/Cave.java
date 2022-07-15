package com.company.Location.BattleLocation;

import com.company.Database.Monsters.Monster;
import com.company.Database.Monsters.Zombie;
import com.company.Player.Player;

public class Cave extends BattleLocation {
    public Cave() {
        super();
        super.numberOfEnemies = rng.nextInt(3) + 1;
        super.monsters = new Monster[numberOfEnemies];
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = new Zombie();
        }
    }

    @Override
    public Player action(Player p) {
        return null;
    }

    public void combat() {

    }
}
