package com.company.Database.Weapons;

import java.util.HashMap;
import java.util.Map;

public class Weapons{
    static private Map<Integer,Weapon> weaponsData=new HashMap<>();
    static {
        weaponsData.put(1,new Pistol());
        weaponsData.put(2,new Sword());
        weaponsData.put(3,new Rifle());
    }
    private Weapons(){

    }
    public static Weapon getWeaponById(int id){
        return weaponsData.get(id);
    }
}
