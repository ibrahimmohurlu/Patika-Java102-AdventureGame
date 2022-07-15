package com.company.Location.BattleLocation;

import com.company.Database.Monsters.Monster;
import com.company.Location.Location;
import com.company.Player.Player;

import java.util.Random;

public abstract class BattleLocation extends Location {
    public abstract Player action(Player p);
    public abstract void combat();
    protected Monster[] monsters;
    protected int numberOfEnemies;
    Random rng = new Random();

}
