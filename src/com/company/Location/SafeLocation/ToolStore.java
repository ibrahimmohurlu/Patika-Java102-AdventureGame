package com.company.Location.SafeLocation;

import com.company.Database.Armors.Armor;
import com.company.Database.Armors.Armors;
import com.company.Database.Weapons.Weapon;
import com.company.Database.Weapons.Weapons;
import com.company.Player.Player;

import java.util.Scanner;

public class ToolStore extends SafeLocation {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void action(Player p) {
        System.out.println("You are in tool store. You can buy items here.");
        int choice;
        do {
            System.out.println("You have " + p.getMoney() + " coins.");
            listMenu();
            choice = scanner.nextInt();
            boolean selected = false;
            switch (choice) {
                case 1:
                    selected = false;
                    while (!selected) {
                        listWeapons(p);
                        System.out.println("[0] Back");
                        System.out.println("Select an ID to buy");
                        int id = scanner.nextInt();
                        if (id == 0) {
                            break;
                        } else if (p.getMoney() >= Weapons.getWeaponById(id).getPrice() && !(p.getSelectedWeapon().getID() == Weapons.getWeaponById(id).getID())) {
                            buyWeapon(p, id);
                            selected = true;
                        } else if (p.getSelectedWeapon().getID() == Weapons.getWeaponById(id).getID()) {
                            System.out.println("You cannot buy the weapon you already have!");
                        } else {
                            System.out.println("You dont have enough money!");
                        }
                    }
                    break;
                case 2:
                    selected = false;
                    while (!selected) {
                        listArmors(p);
                        System.out.println("[0] Back");
                        System.out.println("Select an ID to buy");
                        int id = scanner.nextInt();
                        if (id == 0) {
                            break;
                        } else if (p.getMoney() >= Armors.getArmorById(id).getPrice() && !(p.getSelectedArmor().getID() == Armors.getArmorById(id).getID())) {
                            buyArmor(p, id);
                            selected = true;
                        } else if (p.getSelectedArmor().getID() == Armors.getArmorById(id).getID()) {
                            System.out.println("You cannot buy the armor you already have!");
                        } else {
                            System.out.println("You dont have enough money!");
                        }
                    }
                    break;
            }
        }
        while (choice != 3);

    }

    private void listMenu() {
        System.out.println("Items you can buy:");
        System.out.println("[1] Weapons");
        System.out.println("[2] Armors");
        System.out.println("[3] Exit");
    }

    private void buyWeapon(Player p, int id) {
        Weapon selectedWeapon = Weapons.getWeaponById(id);
        p.setSelectedWeapon(selectedWeapon);
        p.setMoney(p.getMoney() - selectedWeapon.getPrice());
    }

    private void buyArmor(Player p, int id) {
        Armor selectedArmor = Armors.getArmorById(id);
        p.setSelectedArmor(selectedArmor);
        p.setMoney(p.getMoney() - selectedArmor.getPrice());
    }

    private void listWeapons(Player p) {
        Weapons.getWeaponsData().forEach((key, value) -> {
            Weapon current = (Weapon) value;
            if (p.getSelectedWeapon().getID() == current.getID()) {
                System.out.println(String.format("ID:%d, %s, Damage:%d, Price:%d. You cannot buy this weapon you already have it.", current.getID(), current.getName(), current.getDamage(), current.getPrice()));
            } else {
                System.out.println(String.format("ID:%d, %s, Damage:%d, Price:%d", current.getID(), current.getName(), current.getDamage(), current.getPrice()));
            }

        });
    }

    private void listArmors(Player p) {
        Armors.getArmorsData().forEach((key, value) -> {
            Armor current = (Armor) value;
            if (p.getSelectedArmor().getID() == current.getID()) {
                System.out.println(String.format("ID:%d, %s, Block Value:%d, Price:%d. You cannot buy this armor you already have it.", current.getID(), current.getType(), current.getBlock(), current.getPrice()));
            } else {
                System.out.println(String.format("ID:%d, %s, Block Value:%d, Price:%d", current.getID(), current.getType(), current.getBlock(), current.getPrice()));
            }
        });
    }
}
