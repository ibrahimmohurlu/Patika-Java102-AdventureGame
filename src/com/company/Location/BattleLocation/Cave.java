package com.company.Location.BattleLocation;

import com.company.Database.Monsters.Monster;
import com.company.Database.Monsters.Zombie;
import com.company.Player.Player;

public class Cave extends BattleLocation {
    public Cave() {
        super();
        this.numberOfEnemies = this.rng.nextInt(3) + 1;
        this.monsters = new Monster[numberOfEnemies];
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = new Zombie();
        }
    }

    @Override
    public Player action(Player p) {
        return null;
    }

}
