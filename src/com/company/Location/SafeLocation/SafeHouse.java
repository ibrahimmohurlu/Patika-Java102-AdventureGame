package com.company.Location.SafeLocation;

import com.company.Player.Player;

public class SafeHouse extends SafeLocation{
    @Override
    public void action(Player p) {
        // SafeHouse set player health to max health
        System.out.println("You are in safe house. You are rested and your health maxed!");
        p.setHealth(p.getMaxHealth());
    }
}
