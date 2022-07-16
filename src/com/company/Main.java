package com.company;

import com.company.Location.BattleLocation.BattleLocation;
import com.company.Location.BattleLocation.Cave;
import com.company.Location.BattleLocation.Forest;
import com.company.Location.BattleLocation.River;
import com.company.Player.Player;


public class Main {

    public static void main(String[] args) {
        BattleLocation cave = new River();
        cave.combat(new Player(1,1,1));

    }
}
