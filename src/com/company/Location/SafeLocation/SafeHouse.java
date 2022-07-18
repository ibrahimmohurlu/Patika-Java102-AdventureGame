package com.company.Location.SafeLocation;

import com.company.Player.Player;

import java.util.Scanner;

public class SafeHouse extends SafeLocation {
    @Override
    public void action(Player p) {
        // SafeHouse set player health to max health
        System.out.println("You are in safe house. You are rested and your health maxed!");
        p.setHealth(p.getMaxHealth());
        System.out.println("[0] Back");
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
    }
}
