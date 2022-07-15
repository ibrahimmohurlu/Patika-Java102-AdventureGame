package com.company.Database.Armors;

public class Armor {
    private int ID;
    private String type;
    private int block;
    private int price;

    public Armor(int ID, String type, int block, int price) {
        this.ID = ID;
        this.type = type;
        this.block = block;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public String getType() {
        return type;
    }

    public int getBlock() {
        return block;
    }

    public int getPrice() {
        return price;
    }
}
