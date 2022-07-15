package com.company.Location.SafeLocation;

import com.company.Location.Location;
import com.company.Player.Player;

public abstract class SafeLocation extends Location {
    @Override
    public abstract Player action(Player p);
}
