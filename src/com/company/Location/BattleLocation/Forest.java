package com.company.Location.BattleLocation;

import com.company.Database.Monsters.Monster;
import com.company.Database.Monsters.Vampire;
import com.company.Player.Player;

public class Forest extends BattleLocation {
    public Forest() {
        super();
        this.numberOfEnemies = this.rng.nextInt(3) + 1;
        this.monsters = new Monster[numberOfEnemies];
        this.itemDrops = "Firewood";
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = new Vampire();
        }
    }

    @Override
    public void action(Player p) {

    }

    @Override
    protected void receiveItem(Player p) {
        p.getInventory().setFirewood(true);
    }
}
