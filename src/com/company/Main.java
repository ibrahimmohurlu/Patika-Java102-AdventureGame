package com.company;


import com.company.Location.SafeLocation.ToolStore;
import com.company.Player.Player;


public class Main {

    public static void main(String[] args) {
        ToolStore ts = new ToolStore();
        ts.action(new Player(1, 2, 1));

    }
}
