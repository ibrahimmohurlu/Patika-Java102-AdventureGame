package com.company.Database.Armors;

import java.util.HashMap;
import java.util.Map;

public class Armors {
    static private Map<Integer, Armor> armorsData = new HashMap<>();

    static {
        armorsData.put(1, new Cloth());
        armorsData.put(2, new Leather());
        armorsData.put(3, new Plate());
    }

    private Armors() {

    }

    public static Armor getArmorById(int id) {
        return armorsData.get(id);
    }
}
