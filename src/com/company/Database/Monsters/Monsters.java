package com.company.Database.Monsters;

import java.util.HashMap;
import java.util.Map;

public class Monsters {
    static private Map<Integer,Monster> monstersData=new HashMap<>();
    static {
        monstersData.put(1,new Zombie());
        monstersData.put(2,new Vampire());
        monstersData.put(3,new Bear());
    }
    private Monsters(){

    }
    public static Monster getMonsterById(int id){
        return monstersData.get(id);
    }
}
