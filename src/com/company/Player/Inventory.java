package com.company.Player;


public class Inventory {
    private boolean water;
    private boolean food;
    private boolean firewood;

    public Inventory() {

        this.water = false;
        this.food = false;
        this.firewood = false;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

}
