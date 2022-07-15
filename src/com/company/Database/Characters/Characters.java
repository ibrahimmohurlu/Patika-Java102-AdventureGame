package com.company.Database.Characters;

import java.util.HashMap;
import java.util.Map;

public class Characters {
    static private Map<Integer,Character> charactersData=new HashMap<>();
    static {
        charactersData.put(1,new Samurai());
        charactersData.put(2,new Archer());
        charactersData.put(3,new Knight());
    }
    private Characters(){
    }
    public static Character getCharacterById(int id){
        return charactersData.get(id);
    }


}
