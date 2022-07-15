package com.company.Location.SafeLocation;

import com.company.Player.Player;

public class SafeHouse extends SafeLocation{
    @Override
    public Player action(Player p) {
        // SafeHouse set player health to max health
        p.setHealth(p.getMaxHealth());
        return p;
    }
}
