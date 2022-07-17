package com.company.Location.BattleLocation;

import com.company.Database.Monsters.Bear;
import com.company.Database.Monsters.Monster;
import com.company.Database.Monsters.Vampire;
import com.company.Player.Player;

public class River extends BattleLocation {
    public River() {
        super();
        this.numberOfEnemies = this.rng.nextInt(3) + 1;
        this.itemDrops = "Water";
        this.moneyDrop = 35;
        this.monsters = new Monster[numberOfEnemies];
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = new Bear();
        }
    }


    @Override
    protected void receiveItem(Player p) {
        p.getInventory().setWater(true);
    }
}

