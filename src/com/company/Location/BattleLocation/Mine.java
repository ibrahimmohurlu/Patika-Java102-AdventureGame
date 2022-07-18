package com.company.Location.BattleLocation;

import com.company.Database.Armors.Armors;
import com.company.Database.Monsters.Monster;
import com.company.Database.Monsters.Snake;
import com.company.Database.Weapons.Weapons;
import com.company.Player.Player;

public class Mine extends BattleLocation {
    private int itemDropsId;

    public Mine() {
        super();
        this.numberOfEnemies = this.rng.nextInt(5) + 1;
        this.monsters = new Monster[numberOfEnemies];
        this.itemDropsId = -1;
        this.itemDrops = "";
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = new Snake();
        }
        if (percentChance(0.15)) {
            //drop weapon
            if (percentChance(0.20)) {
                this.itemDrops = "Rifle";
                this.itemDropsId = 3;
            } else if (percentChance(0.30)) {
                this.itemDrops = "Sword";
                this.itemDropsId = 2;
            } else {
                this.itemDrops = "Pistol";
                this.itemDropsId = 1;
            }
        } else if (percentChance(0.15)) {
            //drop armor
            if (percentChance(0.20)) {
                this.itemDrops = "Plate Armor";
                this.itemDropsId = 3;
            } else if (percentChance(0.30)) {
                this.itemDrops = "Leather Armor";
                this.itemDropsId = 2;
            } else {
                this.itemDrops = "Cloth Armor";
                this.itemDropsId = 1;
            }
        } else if (percentChance(0.25)) {
            //drop money
            if (percentChance(0.20)) {
                this.moneyDrop = 10;
            } else if (percentChance(0.30)) {
                this.moneyDrop = 5;
            } else {
                this.moneyDrop = 1;
            }

        } else {
            //drop nothing :(
            this.itemDropsId = -1;
            this.itemDrops = "";
        }

    }

    private static Boolean percentChance(double chance) {
        return Math.random() <= chance;
    }

    @Override
    public void action(Player p) {
        this.combat(p);
    }

    @Override
    protected void receiveItem(Player p) {
        if (itemDrops.equals("Pistol") || itemDrops.equals("Sword") || itemDrops.equals("Rifle")) {
            p.setSelectedWeapon(Weapons.getWeaponById(this.itemDropsId));
        } else {
            p.setSelectedArmor(Armors.getArmorById(this.itemDropsId));
        }
    }
}
