package com.company.Location.BattleLocation;

import com.company.Database.Monsters.Monster;
import com.company.Location.Location;
import com.company.Player.Player;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public abstract class BattleLocation extends Location {
    public abstract void action(Player p);

    protected Monster[] monsters;
    protected int numberOfEnemies;
    protected String itemDrops;
    Random rng = new Random();

    protected abstract void receiveItem(Player p);

    public void combat(Player p) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = this.getClass().getName().split("\\.");
        String battleLocationName = tokens[tokens.length - 1];
        System.out.println(String.format("You have entered the %s. There are %d %ss you have to battle!",
                battleLocationName, this.numberOfEnemies, monsters[0].getName()));


        while (!Arrays.stream(monsters).allMatch(m -> m.getHealth() <= 0)) {
            System.out.println("Your health is " + p.getHealth() + ". Enemies = " + getMonsterStatus());
            System.out.println("Select an enemy index to attack !");

            int index = scanner.nextInt() - 1;
            if (index >= monsters.length) {
                System.out.println("Please select a valid enemy index!");
            } else {
                System.out.println("Attacked " + (index + 1) + "." + monsters[index].getName() + " and monster received " + p.getDamage() + " damage.");
                monsters[index].receiveDamage(p.getDamage());
                for (int i = 0; i < monsters.length; i++) {
                    //only alive monster can attack
                    if(monsters[i].getHealth()>0){
                        System.out.println(String.format("You received %d damage from %d. %s", monsters[i].getDamage() - p.getBlockValue(), i + 1, monsters[i].getName()));
                        p.receiveDamage(monsters[i].getDamage());
                    }

                }
                if (p.getHealth() <= 0) {
                    System.out.println("You are dead!");
                    break;
                }
            }

        }
        if (Arrays.stream(monsters).allMatch(m -> m.getHealth() <= 0)) {
            System.out.println("You won the battle! You received " + this.itemDrops + ".");
            this.receiveItem(p);
        }


    }

    protected String getMonsterStatus() {
        String[] statusOfMonsters = new String[monsters.length];
        for (int i = 0; i < monsters.length; i++) {
            if (monsters[i].getHealth() <= 0) {
                statusOfMonsters[i] = String.format("{%d. %s is dead.}", i + 1, monsters[i].getName());
            } else {
                statusOfMonsters[i] = String.format("{%d. %s has %d health.}", i + 1, monsters[i].getName(), monsters[i].getHealth());
            }

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
