package com.company.Database.Characters;

public class Character {
    private int ID;
    private int damage;
    private int health;
    private int money;
    private String name;

    public Character(int ID, String name, int damage, int health, int money) {
        this.ID = ID;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public int getID() {
        return ID;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }
}
