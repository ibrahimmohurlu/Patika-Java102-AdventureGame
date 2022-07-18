package com.company.Database.Monsters;

import java.util.Random;

public class Snake extends Monster {
    private static Random rng = new Random();

    public Snake() {
        super(4, "Snake", 3 + rng.nextInt(4), 12, 0);
    }
}
