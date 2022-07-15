package com.company.Player;

import com.company.Database.Armors.Armor;
import com.company.Database.Armors.Armors;
import com.company.Database.Characters.Character;
import com.company.Database.Characters.Characters;
import com.company.Database.Weapons.Weapon;
import com.company.Database.Weapons.Weapons;

public class Player {
    private Character selectedCharacter;
    private Weapon selectedWeapon;
    private Armor selectedArmor;

    private Inventory inventory;

    private int damage;
    private int blockValue;
    private int health;
    private int money;

    public Player(int characterId, int weaponId, int armorId) {
        this.selectedCharacter = Characters.getCharacterById(characterId);
        this.selectedWeapon = Weapons.getWeaponById(weaponId);
        this.selectedArmor = Armors.getArmorById(armorId);

        this.inventory = new Inventory();

        if (selectedCharacter != null && selectedWeapon != null && selectedArmor != null) {
            this.damage = this.selectedWeapon.getDamage() + this.selectedCharacter.getDamage();
            this.blockValue = this.selectedArmor.getBlock();
            this.health = this.selectedCharacter.getHealth();
            this.money = this.selectedCharacter.getMoney();
        } else {
            System.out.println("Error on choosing character, weapon or armor");
        }

    }

    public void addMoney(int amount) {
        this.money += amount;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public int getBlockValue() {
        return blockValue;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }
}
