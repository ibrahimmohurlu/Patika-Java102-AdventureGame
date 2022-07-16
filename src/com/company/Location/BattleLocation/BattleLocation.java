package com.company.Location.BattleLocation;

import com.company.Database.Monsters.Monster;
import com.company.Location.Location;
import com.company.Player.Player;

import java.util.Random;
import java.util.Scanner;

public abstract class BattleLocation extends Location {
    public abstract Player action(Player p);

    protected Monster[] monsters;
    protected int numberOfEnemies;
    Random rng = new Random();

    public void combat(Player p) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = this.getClass().getName().split("\\.");
        String battleLocationName = tokens[tokens.length - 1];
        System.out.println(String.format("You have entered the %s. There are %d %ss you have to battle!",
                battleLocationName, this.numberOfEnemies, monsters[0].getName()));
        System.out.println("Your health is " + p.getHealth() + ". Enemies = " + getMonsterStatus());
        System.out.println("Select an enemy index to attack !");
        int index = scanner.nextInt() - 1;
        System.out.println("Attacked " + (index + 1) + "." + monsters[index].getName() + " and monster received" + p.getDamage() + "damage.");
        monsters[index].receiveDamage(p.getDamage());
        System.out.println("Your health is " + p.getHealth() + ". Enemies = " + getMonsterStatus());

    }

    protected String getMonsterStatus() {
        String[] statusOfMonsters = new String[monsters.length];
        for (int i = 0; i < monsters.length; i++) {
            statusOfMonsters[i] = String.format("{%d. %s has %d health.}", i + 1, monsters[i].getName(), monsters[i].getHealth());
        }
        String finalStatus = "";
        for (String s : statusOfMonsters) {
            finalStatus += s;
        }
        return finalStatus;
    }

    public int getNumberOfEnemies() {
        return numberOfEnemies;
    }

    public Monster[] getMonsters() {
        return monsters;
    }
}
