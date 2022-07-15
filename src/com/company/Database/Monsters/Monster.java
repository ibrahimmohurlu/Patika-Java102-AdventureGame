package com.company.Database.Monsters;

public class Monster {
    private int ID;
    private String name;
    private int damage;
    private int health;
    private int money;

    public Monster(int ID, String name, int damage, int health, int money) {
        this.ID = ID;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
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
}
