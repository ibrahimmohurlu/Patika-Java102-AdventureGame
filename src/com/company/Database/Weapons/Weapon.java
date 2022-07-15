package com.company.Database.Weapons;

public class Weapon {
    private int ID;
    private String name;
    private int damage;
    private int price;

    public Weapon(int ID, String name, int damage, int price) {
        this.ID = ID;
        this.name = name;
        this.damage = damage;
        this.price = price;
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

    public int getPrice() {
        return price;
    }
}
