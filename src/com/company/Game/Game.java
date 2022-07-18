package com.company.Game;

import com.company.Database.Characters.Character;
import com.company.Database.Characters.Characters;
import com.company.Location.BattleLocation.Cave;
import com.company.Location.BattleLocation.Forest;
import com.company.Location.BattleLocation.Mine;
import com.company.Location.BattleLocation.River;
import com.company.Location.SafeLocation.SafeHouse;
import com.company.Location.SafeLocation.ToolStore;
import com.company.Player.Inventory;
import com.company.Player.Player;

import java.util.Scanner;

public class Game {
    private Player player;
    private Scanner scanner = new Scanner(System.in);

    public Game() {
        System.out.println("You wake up at a unknown safe house. You must get food,water and firewood to survive.");
        System.out.println("You can gather these items in various dangerous places. You can get food from Cave, firewood from Forest and water from River.");
        System.out.println("There are monsters in those places. We recommend you to start from Cave because it is the least dangerous one.");
        System.out.println("Now select your character to start.");
        boolean selected = false;
        int id = -1;
        while (!selected) {

            Characters.getCharactersData().forEach((key, value) -> {
                Character currentCharacter = (Character) value;
                System.out.println(String.format("ID:%d, %s, Damage:%d Health:%d Initial Money:%d ", currentCharacter.getID(), currentCharacter.getName(), currentCharacter.getDamage(), currentCharacter.getHealth(), currentCharacter.getMoney()));
            });
            System.out.println("Select your character:");
            id = scanner.nextInt();
            if (id >= 1 && id <= 3) {
                selected = true;
            } else {
                System.out.println("Enter a valid value!");
            }
        }
        player = new Player(id, 1, 1);
    }

    public void start() {
        boolean gameEnded = false;
        while (!gameEnded) {
            printMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printCharacterInfo();
                    break;
                case 2:
                    player.setPlayerLocation(new ToolStore());
                    player.getPlayerLocation().action(player);
                    break;
                case 3:
                    player.setPlayerLocation(new SafeHouse());
                    player.getPlayerLocation().action(player);
                    Inventory playerInventory = player.getInventory();
                    if (playerInventory.isFood() && playerInventory.isWater() && playerInventory.isFirewood()) {
                        System.out.println("You have all the items to survive game is ended but you can continue to figth!");
                        scanner.nextInt();
                    }
                    break;
                case 4:
                    player.setPlayerLocation(new Cave());
                    player.getPlayerLocation().action(player);
                    break;
                case 5:
                    player.setPlayerLocation(new Forest());
                    player.getPlayerLocation().action(player);
                    break;
                case 6:
                    player.setPlayerLocation(new River());
                    player.getPlayerLocation().action(player);
                    break;
                case 7:
                    player.setPlayerLocation(new Mine());
                    player.getPlayerLocation().action(player);
                    break;
                case 8:
                    gameEnded = true;
                    break;
                default:
                    System.out.println("Choose a valid value!");
                    choice = scanner.nextInt();
                    break;

            }
            if (player.getHealth() <= 0) {
                gameEnded = true;
            }
        }

    }

    private void printMenu() {
        System.out.println("Choose an action:");
        System.out.println("[1] Character info");
        System.out.println("[2] Go to tool store");
        System.out.println("[3] Go to safe house");
        System.out.println("[4] Go to Cave");
        System.out.println("[5] Go to Forest");
        System.out.println("[6] Go to River");
        System.out.println("[7] Go to Mine");
        System.out.println("[8] Quit");
    }


    private void printCharacterInfo() {
        String characterName = player.getSelectedCharacterName();
        String characterInfo = String.format("Total damage:%d, Block Value:%d, Health:%d/%d, Money:%d,",
                player.getDamage() + player.getSelectedWeapon().getDamage(),
                player.getSelectedArmor().getBlock(),
                player.getHealth(),
                player.getMaxHealth(),
                player.getMoney());
        String weaponInfo = String.format("Weapon: %s Damage:%d",
                player.getSelectedWeapon().getName(),
                player.getSelectedWeapon().getDamage());
        String armorInfo = String.format("Armor: %s, Block Value:%d",
                player.getSelectedArmor().getType(),
                player.getSelectedArmor().getBlock());
        String inventory = String.format("Food:[%s], Firewood:[%s], Water:[%s]",
                player.getInventory().isFood() ? "\u2713" : "x",
                player.getInventory().isFirewood() ? "\u2713" : "x",
                player.getInventory().isWater() ? "\u2713" : "x");
        System.out.println(characterName);
        System.out.println(characterInfo);
        System.out.println(weaponInfo);
        System.out.println(armorInfo);
        System.out.println(inventory);
        System.out.println("[0] Back.");
        scanner.nextInt();
    }
}
