package com.company.Location.BattleLocation;

import com.company.Database.Monsters.Monster;
import com.company.Database.Monsters.Zombie;
import com.company.Player.Player;

public class Cave extends BattleLocation {
    public Cave() {
        super();
        this.numberOfEnemies = this.rng.nextInt(3) + 1;
        this.monsters = new Monster[numberOfEnemies];
        this.itemDrops = "Food";
        this.moneyDrop = 15;
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = new Zombie();
        }
    }

    @Override
    protected void receiveItem(Player p) {
        p.getInventory().setFood(true);
    }
}
