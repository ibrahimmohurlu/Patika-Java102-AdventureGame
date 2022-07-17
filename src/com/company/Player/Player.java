package com.company.Player;

import com.company.Database.Armors.Armor;
import com.company.Database.Armors.Armors;
import com.company.Database.Characters.Character;
import com.company.Database.Characters.Characters;
import com.company.Database.Weapons.Weapon;
import com.company.Database.Weapons.Weapons;
import com.company.Location.Location;
import com.company.Location.SafeLocation.SafeHouse;

public class Player {
    private Character selectedCharacter;
    private Weapon selectedWeapon;
    private Armor selectedArmor;

    private Inventory inventory;

    private Location playerLocation;

    private int damage;
    private int blockValue;
    private int health;
    private int maxHealth;
    private int money;

    public Player(int characterId, int weaponId, int armorId) {
        this.selectedCharacter = Characters.getCharacterById(characterId);
        this.selectedWeapon = Weapons.getWeaponById(weaponId);
        this.selectedArmor = Armors.getArmorById(armorId);

        if (selectedCharacter != null && selectedWeapon != null && selectedArmor != null) {
            this.damage = this.selectedWeapon.getDamage() + this.selectedCharacter.getDamage();
            this.blockValue = this.selectedArmor.getBlock();
            this.maxHealth = this.selectedCharacter.getHealth();
            this.health = this.maxHealth;
            this.money = this.selectedCharacter.getMoney();
        } else {
            System.out.println("Error on choosing character, weapon or armor");
        }

        this.inventory = new Inventory();
        this.playerLocation = new SafeHouse();

    }

    public void setPlayerLocation(Location playerLocation) {
        this.playerLocation = playerLocation;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setSelectedWeapon(Weapon selectedWeapon) {
        this.selectedWeapon = selectedWeapon;
    }

    public void setSelectedArmor(Armor selectedArmor) {
        this.selectedArmor = selectedArmor;
    }

    public void addMoney(int amount) {
        this.money += amount;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }
    public Inventory getInventory(){
        return this.inventory;
    }

    public Weapon getSelectedWeapon() {
        return selectedWeapon;
    }

    public Armor getSelectedArmor() {
        return selectedArmor;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getBlockValue() {
        return this.blockValue;
    }

    public int getHealth() {
        return this.health;
    }

    public int getMoney() {
        return this.money;
    }

    public void receiveDamage(int damage) {
        this.health -= (damage - this.blockValue);
    }
}
